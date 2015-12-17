package com.lvsong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lvsong on 7/9/15.
 */
public class MultiThreadMain {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 2; i++) {
            pool.submit(new ThreadTask());
        }

        pool.shutdown();
    }
}
