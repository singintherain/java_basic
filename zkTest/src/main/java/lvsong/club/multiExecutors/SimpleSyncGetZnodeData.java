package lvsong.club.multiExecutors;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by lvsong on 5/5/16.
 */
public class SimpleSyncGetZnodeData implements Watcher {
    private String path;
    private MultiThreadGetZkNodeData multiThreadGetZkNodeData;

    public SimpleSyncGetZnodeData(MultiThreadGetZkNodeData multiThreadGetZkNodeData, String path) {
        this.path = path;
        this.multiThreadGetZkNodeData = multiThreadGetZkNodeData;
    }

    @Override
    public void process(WatchedEvent event) {
        if(Event.KeeperState.SyncConnected == event.getState()) {
            new Thread(new GetZnodeDataTask(multiThreadGetZkNodeData, path)).start();
        }
    }
}
