package lvsong.club;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lvsong on 4/15/16.
 */
public class SimpleZookeeperConnector implements Watcher {
    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper =
                new ZooKeeper(
                        "127.0.0.1:2181",
                        5000,
                        new SimpleZookeeperConnector()
                );
        System.out.println(zooKeeper.getState());
        System.out.println("main Thread: " + Thread.currentThread().getId());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
        }

        long sessionId = zooKeeper.getSessionId();
        byte[] password = zooKeeper.getSessionPasswd();

        System.out.println("Zookeeper session established.");
        System.out.println("-------------------------------------------");
        zooKeeper =
                new ZooKeeper(
                        "127.0.0.1:2181",
                        5000,
                        new SimpleZookeeperConnector(),
                        1l,
                        "test".getBytes()
                );
        System.out.println(zooKeeper.getState());
        System.out.println("main Thread: " + Thread.currentThread().getId());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
        }

        System.out.println("-------------------------------------------");
        zooKeeper =
                new ZooKeeper(
                        "127.0.0.1:2181",
                        5000,
                        new SimpleZookeeperConnector(),
                        sessionId,
                        password
                );
        System.out.println(zooKeeper.getState());
        System.out.println("main Thread: " + Thread.currentThread().getId());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
        }

    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event: " + event);
        System.out.println("process Thread: " + Thread.currentThread().getId());
        if(event.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }

    }
}
