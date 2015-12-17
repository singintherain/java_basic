package lvsong.club.domain;

import kafka.consumer.ConsumerConfig;

import java.util.Properties;

/**
 * Created by lvsong on 12/3/15.
 */
public class ConsumerConfigFactory {
    public static ConsumerConfig createConsumerConfig(String zookeeper, String groupId) {
        Properties properties = new Properties();

        properties.put("zookeeper.connect", zookeeper);
        properties.put("group.id", groupId);
        properties.put("zookeeper.session.timeout.ms", "400");
        properties.put("zookeeper.sync.time.ms", "200");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("client.id", "myAppTest");

        return new ConsumerConfig(properties);
    }
}
