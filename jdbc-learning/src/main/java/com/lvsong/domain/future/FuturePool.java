package com.lvsong.domain.future;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lvsong on 12/24/15.
 */
public class FuturePool {
    private static final Log LOG = LogFactory.getLog(FuturePool.class);
    private ExecutorService executorService;
    private int poolSize;

    public FuturePool(int poolSize) {
        this.poolSize = poolSize;
        initPool();
    }

    public void initPool() {
        executorService = Executors.newFixedThreadPool(poolSize);
    }

    public void submit(Runnable task) {
        executorService.submit(task);
    }
}
