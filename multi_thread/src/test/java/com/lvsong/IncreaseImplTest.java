package com.lvsong;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

/**
 * Created by lvsong on 7/8/15.
 */
public class IncreaseImplTest {
    private void increase(final Increasable increasable) throws Throwable {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future f1 = pool.submit(new Runnable() {
            public void run() {
                increasable.increase(13);
                System.out.println(Thread.currentThread().getName());
            }
        });

        Future f2 = pool.submit(new Runnable() {
            public void run() {
                increasable.increase(19);
                System.out.println(Thread.currentThread().getName());
            }
        });

        try {
            f1.get();
            f2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            throw e.getCause();
        } finally {
            pool.shutdown();
        }
    }

    @Test
    public void increaseTest() {
        boolean flag = true;

        try {
            increase(new IncreaseImpl());
        } catch (Throwable throwable) {
            assertEquals("Count state is illegal", throwable.getMessage());
            flag = false;
        }

        assertEquals(flag, true);
    }

    @Test
    public void testSynchronizedIncreable() {
        boolean flag = true;

        Increasable increasable = SynchronizeHandler.newProxy(new IncreaseImpl());

        for(int i = 0; i < 1000; i++) {

            try {
                increase(new IncreaseImpl());
            } catch (Throwable throwable) {
                assertEquals("Count state is illegal", throwable.getMessage());

            }
        }

        assertEquals(flag, true);
    }
}
