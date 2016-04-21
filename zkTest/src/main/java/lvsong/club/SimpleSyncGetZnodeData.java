package lvsong.club;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lvsong on 4/19/16.
 */
public class SimpleSyncGetZnodeData implements Watcher {
    private static final CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String path = "/zk-book";
        zk = new ZooKeeper(
                "127.0.0.1:2181",
                5000,
                new SimpleSyncGetZnodeData()
        );

        connectedSemaphore.await();

        zk.create(
                path,
                "123".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL
        );

        System.out.println(path + "--" + new String(zk.getData(path, true, stat)));
        System.out.println(path + "--" + stat.getCzxid() + "," + stat.getMzxid() + "," + stat.getVersion());
        zk.setData(path, "123".getBytes(), -1);
        System.out.println(path + " changed");
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        if(Event.KeeperState.SyncConnected == event.getState()) {
            if(Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            } else if(event.getType() == Event.EventType.NodeDataChanged) {
                try {
                    System.out.println(event.getPath() + "--" + new String(zk.getData(
                            event.getPath(), true, stat
                    )));
                    System.out.println(event.getPath() + "--" + stat.getCzxid() + "," + stat.getMzxid() + "," + stat.getVersion());
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
