package lvsong.club.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lvsong on 12/3/15.
 */
public class ConsumerThreadPool {
    private static final Log LOG = LogFactory.getLog(ConsumerThreadPool.class);
    private ExecutorService pool;
    private String topicName;
    private int poolSize;

    /**
     *
     * @param name 线程池的名字也是注册的topic消息的名称
     * @param poolSize
     */
    public ConsumerThreadPool(String name, int poolSize) {
        this.topicName = name;
        this.poolSize = poolSize;
        pool = Executors.newFixedThreadPool(poolSize);
        LOG.info("新建consumer线程池, 该consumer注册的topic是: " + name + ", 大小为: " + poolSize);
    }

    public void submit(MyConsumer consumer) {
        pool.submit(consumer);
    }

    public String getTopicName() {
        return topicName;
    }

    public int getPoolSize() {
        return poolSize;
    }
}
