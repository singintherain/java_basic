package lvsong.club.domain;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvsong on 12/3/15.
 */
public class MyConsumerTest {
    private static final Log LOG = LogFactory.getLog(MyConsumerTest.class);

    private static final String TOPIC = "my_test6";
    private static final int THREAD_NUMBER = 2;
    private static final String ZOOKEEPER = "127.0.0.1:2181";
    private static final String GROUPID = "group1";

    private ConsumerThreadPool myTestTopicConsumerThreadPool;
    private ConsumerConnector consumerConnector;
    private ConsumerConfig consumerConfig;

    @Before
    public void startUp() {
        myTestTopicConsumerThreadPool = ConsumerThreadPoolFactory.createPool(TOPIC, THREAD_NUMBER);
        consumerConfig = ConsumerConfigFactory.createConsumerConfig(ZOOKEEPER, GROUPID);
        consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
        LOG.info("初始化consumer连接");
    }

    @Test
    public void startUpTest() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(TOPIC, THREAD_NUMBER);

        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap =
                consumerConnector.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(TOPIC);

        int threadNumber = 0;

        LOG.info("kafkaStream数量：" + streams.size());

        for(final KafkaStream stream : streams) {
            myTestTopicConsumerThreadPool.submit(new MyConsumer(stream, threadNumber));
            threadNumber++;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
