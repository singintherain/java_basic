package lvsong.club.multiExecutors;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by lvsong on 5/5/16.
 */
public class MultiThreadGetZkNodeData {
    private volatile Object source;
    private ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException {
        MultiThreadGetZkNodeData multiThreadGetZkNodeData = new MultiThreadGetZkNodeData();

        String path = "/zk-test";
        multiThreadGetZkNodeData.setZooKeeper(
                new ZooKeeper(
                "127.0.0.1:2181",
                5000,
                new SimpleSyncGetZnodeData(multiThreadGetZkNodeData, path)
        ));

        new Thread(new PrintSourceTask(multiThreadGetZkNodeData)).start();
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }
}
