package lvsong.club;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lvsong on 4/15/16.
 */
public class SimpleZookeeperNodeCreator implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper(
                "127.0.0.1:2181",
                5000,
                new SimpleZookeeperNodeCreator()
        );
        countDownLatch.await();
        String path1 = zooKeeper.create(
                "/zk-test-ephemeral",
                "init value".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                CreateMode.PERSISTENT
                CreateMode.EPHEMERAL
//                CreateMode.PERSISTENT_SEQUENTIAL
        );
        System.out.println("Success create znode: " + path1);

        String path2 = zooKeeper.create(
                "/zk-test-ephemeral",
                "init value 2".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL
//                CreateMode.PERSISTENT_SEQUENTIAL
//                CreateMode.PERSISTENT
        );
        System.out.println("Success create znode: " + path2);
    }

    @Override
    public void process(WatchedEvent event) {
        if(Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }
}
