package lvsong.club.multiExecutors;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;

/**
 * Created by lvsong on 5/5/16.
 */
public class GetZnodeDataTask implements Runnable {
    private String path;
    private MultiThreadGetZkNodeData multiThreadGetZkNodeData;

    public GetZnodeDataTask(MultiThreadGetZkNodeData multiThreadGetZkNodeData, String path) {
        this.path = path;
        this.multiThreadGetZkNodeData = multiThreadGetZkNodeData;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--get node data--" + path);
        Stat stat = new Stat();

        try {
            multiThreadGetZkNodeData.setSource(
                    new String(multiThreadGetZkNodeData.getZooKeeper().getData(path, true, stat)));
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
