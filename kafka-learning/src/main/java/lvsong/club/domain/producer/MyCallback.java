package lvsong.club.domain.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Created by lvsong on 1/11/16.
 */
public class MyCallback implements Callback {
    private static final Log LOG = LogFactory.getLog(MyCallback.class);

    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        LOG.info("回调方法，发送消息成功, current_thread_id: " + Thread.currentThread().getId());
    }
}
