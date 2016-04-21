package lvsong.club;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lvsong on 4/19/16.
 */
public class SimpleSyncSetZnodeData implements Watcher {
    private static final CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String path = "/zk-book";
        zooKeeper = new ZooKeeper(
                "127.0.0.1:2181",
                5000,
                new SimpleSyncSetZnodeData()
        );

        connectedSemaphore.await();

        zooKeeper.create(
                path,
                "123".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL
        );

        zooKeeper.getData(path, true, null);

        Stat stat = zooKeeper.setData(path, "456".getBytes(), -1);
        System.out.println(
                stat.getCzxid() + ", " +
                        stat.getMzxid() + ", " +
                        stat.getVersion()
        );

        Stat stat2 = zooKeeper.setData(path, "456".getBytes(), stat.getVersion());
        System.out.println(stat2.getCzxid() + "," + stat2.getMzxid() + ", " + stat2.getVersion());

        try {
            zooKeeper.setData(path, "456".getBytes(), stat.getVersion());
        } catch (KeeperException e) {
            System.out.println("Error: " + e.code() + ", " + e.getMessage());
        }

        Thread.sleep(Integer.MAX_VALUE);
    }
    @Override
    public void process(WatchedEvent event) {
        if(Event.KeeperState.SyncConnected == event.getState()) {
            if(Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            }
        }
    }
}
