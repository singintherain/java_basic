package lvsong.club;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lvsong on 4/19/16.
 */
public class SimpleAsyncGetChildrenNode implements Watcher {
    private static final CountDownLatch semaphore = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String path = "/zk-book";
        zooKeeper = new ZooKeeper(
                "127.0.0.1:2181",
                5000,
                new SimpleAsyncGetChildrenNode()
        );
        semaphore.await();
        zooKeeper.create(
                path, "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT
        );

        zooKeeper.getChildren(path, true, new IChildren2Callback(), null);

        zooKeeper.create(
                path + "/c1", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT
        );

        zooKeeper.getChildren(path, true, new IChildren2Callback(), null);

        zooKeeper.create(
                path + "/c2", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT
        );

        Thread.sleep(3000);
        System.out.println("delete node");
        zooKeeper.delete(path + "/c1", 0);
        zooKeeper.delete(path + "/c2", 0);
        zooKeeper.delete(path, 0);

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        if(Event.KeeperState.SyncConnected == event.getState()) {
            if(Event.EventType.None == event.getType() &&
                    null == event.getPath()) {
                semaphore.countDown();
            } else if (event.getType() == Event.EventType.NodeChildrenChanged) {
                try {
                    System.out.println("ReGet Child: " + zooKeeper.getChildren(event.getPath(), true));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class IChildren2Callback implements AsyncCallback.Children2Callback {
    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
        System.out.println("Get Children znode result: [response code: " + rc + ", params path: "
        + path + ", ctx: " + ctx + ", children list: " + children + ", stat: " + stat);
    }
}
