package com.lvsong;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lvsong on 7/9/15.
 */
public class SimpleThreadTest {
    class InnerClass implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    @Test
    public void runMultiThreadTest() {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for(int i = 0; i < 10; i++) {
            pool.submit(new InnerClass());
        }

        pool.shutdown();
    }
}
