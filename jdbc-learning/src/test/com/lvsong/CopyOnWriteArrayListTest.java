package com.lvsong;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lvsong on 3/12/16.
 */
public class CopyOnWriteArrayListTest {
    private CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
    AtomicInteger
    private CountDownLatch latch = new CountDownLatch(1);

    @Before
    public void setUp() {
        for(int i = 0; i < 20; i++) {
            list.add(i);
        }
    }

    @Test
    public void addIteratorTest() {
        Runnable task1 = new Runnable() {
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                System.out.println("迭代器生成成功, 可以开始减少");
                latch.countDown();
                while(iterator.hasNext()) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(iterator.next());
                }
            }
        };

        Runnable task2 = new Runnable() {
            public void run() {
                try {
                    latch.await();
                    System.out.println("迭代器生成成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 9; i++)
                    list.remove(0);
                for (int i = 0; i < 9; i++) {
                    System.out.println("--"+ list.get(i));
                }
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(task1);
        pool.submit(task2);

        try {
            Thread.currentThread().sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
