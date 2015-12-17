package lvsong.club.domain;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

import java.util.Properties;

/**
 * Created by lvsong on 12/3/15.
 */
public class MyConsumer implements Runnable {
    private KafkaStream kafkaStream;
    private int threadNumber;

    public MyConsumer(KafkaStream kafkaStream, int threadNumber) {
        this.kafkaStream = kafkaStream;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = kafkaStream.iterator();

        while (it.hasNext()) {
            System.out.println("Thread " + threadNumber + ": " + new String(it.next().message()));
        }

        System.out.println("Shutting down Thread: " + threadNumber);
    }

}
