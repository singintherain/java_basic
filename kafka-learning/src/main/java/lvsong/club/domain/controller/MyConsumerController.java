package lvsong.club.domain.controller;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import lvsong.club.domain.ConsumerConfigFactory;
import lvsong.club.domain.ConsumerThreadPool;
import lvsong.club.domain.ConsumerThreadPoolFactory;
import lvsong.club.domain.MyConsumer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvsong on 12/3/15.
 */
public class MyConsumerController {
    private static final Log LOG = LogFactory.getLog(MyConsumerController.class);

    private static String TOPIC = "my_test";
    private static int THREAD_NUMBER = 2;
    private static String ZOOKEEPER = "127.0.0.1:2181";
    private static String GROUPID = "group1";

    /**
     * 默认情况下，参数列表中，0为topic，1为group_id，2为thread_number, 3为zookeeper地址
     * @param args
     */
    public static void main(String[] args) {
        if(args[0] != null) TOPIC = args[0];
        if(args[1] != null) GROUPID = args[1];
        if(args[2] != null) THREAD_NUMBER = Integer.valueOf(args[2]);
        if(args[3] != null) ZOOKEEPER = args[3];

        ConsumerThreadPool myTestTopicConsumerThreadPool;
        ConsumerConnector consumerConnector;
        ConsumerConfig consumerConfig;

        myTestTopicConsumerThreadPool = ConsumerThreadPoolFactory.createPool(TOPIC, THREAD_NUMBER);
        consumerConfig = ConsumerConfigFactory.createConsumerConfig(ZOOKEEPER, GROUPID);
        consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
        LOG.info("初始化consumer连接");

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
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
