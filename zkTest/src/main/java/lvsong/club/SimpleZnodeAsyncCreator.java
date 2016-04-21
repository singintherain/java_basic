package lvsong.club;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lvsong on 4/18/16.
 */
public class SimpleZnodeAsyncCreator implements Watcher {
    private static final CountDownLatch coutDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(
                "127.0.0.1:2181",
                5000,
                new SimpleZnodeAsyncCreator()
        );

        coutDownLatch.await();

        zooKeeper.create(
                "/zk-test-ephemeral-",
                "test".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL,
                new IStringCallback(),
                "I am context"
        );

        zooKeeper.create(
                "/zk-test-ephemeral-",
                "test".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL,
                new IStringCallback(),
                "I am context"
        );

        zooKeeper.create(
                "/zk-test-ephemeral-",
                "test".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL,
                new IStringCallback(),
                "I am context"
        );

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        if(event.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("zookeeper connected");
            coutDownLatch.countDown();
        }
    }
}

class IStringCallback implements AsyncCallback.StringCallback {

    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        System.out.println(
                "Create path result: [" + rc + ", " + path + "," +
                        ctx + ", real path name: " + name
        );
    }
}
