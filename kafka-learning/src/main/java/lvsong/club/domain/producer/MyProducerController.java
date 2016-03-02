package lvsong.club.domain.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by lvsong on 1/11/16.
 */
public class MyProducerController {
    private static final Log LOG = LogFactory.getLog(MyProducerController.class);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9094");
//        props.put("acks", "all");
        props.put("acks", "0");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer(props);

        Callback callback = new MyCallback();

        for(int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("my-test7", Integer.toString(i), Integer.toString(i)), callback);

//        Producer<String, String> producer2 = new KafkaProducer(props);
//
//        Callback callback2 = new MyCallback();
//
//        for(int i = 0; i < 100; i++)
//            producer2.send(new ProducerRecord<String, String>("my-test", Integer.toString(i), Integer.toString(i)), callback2);

        LOG.info("发送消息成功, current_thread_id: " + Thread.currentThread().getId());
        producer.close();
//        producer2.close();
    }
}
