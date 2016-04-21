package lvsong.club;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;

import static org.apache.zookeeper.KeeperException.*;

/**
 * Created by lvsong on 4/15/16.
 */
public class DataMonitor implements Watcher, AsyncCallback.StatCallback {
    private ZooKeeper zk;
    private String znode;
    private Watcher watcher;
    private DataMonitorListener listener;
    boolean dead = false;
    byte prevData[];

    public DataMonitor(ZooKeeper zk, String znode, Watcher chainedWatcher, DataMonitorListener listener) {
        this.zk = zk;
        this.znode = znode;
        this.watcher = chainedWatcher;
        this.listener = listener;

        zk.exists(znode, true, this, null);
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        boolean exists;

        Code code = Code.get(rc);

        switch (code) {
            case OK:
                exists = true;
                break;
            case NONODE:
                exists = false;
                break;
            case SESSIONEXPIRED:
            case NOAUTH:
                dead = true;
                listener.closing(rc);
                return;
            default:
                zk.exists(znode, true, this, null);
                return;
        }

        byte b[] = null;
        if(exists) {
            try {
                b = zk.getData(znode, false, null);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                return;
            }
        }

        if((b == null && b != prevData)
                || (b != null && !Arrays.equals(prevData, b))) {
            listener.exists(b);
            prevData = b;
        }
    }

    @Override
    public void process(WatchedEvent event) {
        String path = event.getPath();
        if(event.getType() == Event.EventType.None) {
            switch (event.getState()) {
                case SyncConnected:
                    System.out.println("session建立成功");
                    break;
                case Expired:
                    dead = true;
                    listener.closing(Code.SESSIONEXPIRED.intValue());
                    break;
            }
        } else {
            if(path != null && path.equals(znode)) {
                zk.exists(znode, true, this, null);
            }
        }

        if(watcher != null) {
            watcher.process(event);
        }
    }

    public interface DataMonitorListener {
        void exists(byte data[]);
        void closing(int rc);
    }
}
