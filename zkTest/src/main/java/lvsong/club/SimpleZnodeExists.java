package lvsong.club;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lvsong on 4/19/16.
 */
public class SimpleZnodeExists implements Watcher {
    private static final CountDownLatch semaphore = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String path = "/zk-book";
        zooKeeper = new ZooKeeper(
                "127.0.0.1:2181",
                5000,
                new SimpleZnodeExists()
        );

        semaphore.await();

        zooKeeper.exists(path ,true);
        zooKeeper.create(
                path,
                "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT
        );
        zooKeeper.setData(path, "123".getBytes(), -1);
        zooKeeper.create(
                path + "/c1",
                "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT
        );
        zooKeeper.delete(path + "/c1", -1);
        zooKeeper.delete(path, -1);
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        try {
            if(Event.KeeperState.SyncConnected == event.getState()) {
                if(event.getType() == Event.EventType.None && null == event.getPath()) {
                    semaphore.countDown();
                } else if(Event.EventType.NodeCreated == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")Created");
                    zooKeeper.exists(event.getPath(), true);
                } else if(Event.EventType.NodeDeleted == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")Deleted");
                    zooKeeper.exists(event.getPath(), true);
                } else if(Event.EventType.NodeDataChanged == event.getType()) {
                    System.out.println("Node(" + event.getPath() + ")DataChanged");
                    zooKeeper.exists(event.getPath(), true);
                }
            }
        } catch (Exception e) {

        }
    }
}
