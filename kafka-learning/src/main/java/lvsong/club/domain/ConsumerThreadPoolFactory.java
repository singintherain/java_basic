package lvsong.club.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvsong on 12/3/15.
 */
public class ConsumerThreadPoolFactory {
    private static Map<String, ConsumerThreadPool> poolMap = new HashMap<String, ConsumerThreadPool>();

    public static ConsumerThreadPool createPool(String poolName, int poolSize) {
        ConsumerThreadPool consumerThreadPool = poolMap.get(poolName);

        if(consumerThreadPool == null) {
            consumerThreadPool = new ConsumerThreadPool(poolName, poolSize);

            poolMap.put(poolName, consumerThreadPool);
        }

        return consumerThreadPool;
    }
}
