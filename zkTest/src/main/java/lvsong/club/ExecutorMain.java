package lvsong.club;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.*;

/**
 * Created by lvsong on 4/15/16.
 */
public class ExecutorMain implements Watcher, Runnable, DataMonitor.DataMonitorListener {
    private String fileName;
    private String[] exec;
    private ZooKeeper zooKeeper;
    private DataMonitor dataMonitor;
    private Process child;

    public static void main(String[] args) throws IOException {
        String hostPort = "127.0.0.1:2181";
        String znode = "zk_test";
        String filename = "";
        String exec[] = new String[3];

        new ExecutorMain(hostPort, znode, filename, exec).run();
    }

    public ExecutorMain(String port, String znode, String fileName, String[] exec) throws IOException {
        this.fileName = fileName;
        this.exec = exec;
        zooKeeper = new ZooKeeper(port, 3000, this);
        dataMonitor = new DataMonitor(zooKeeper, znode, null, this);
    }

    public void run() {
        synchronized (this) {
            while (!dataMonitor.dead) {
                try {
                    System.out.println("dataMonitor is alive!");
                    wait();
                } catch (InterruptedException e) {
                }
            }

            System.out.println("data monitor is dead!");
        }
    }

    public void exists(byte[] data) {
        if(data == null) {
            if(child != null) {
                System.out.println("Killing process");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {
                }
            }
            child = null;
        } else {
            if(child != null) {
                System.out.println("Stopping child");
                child.destroy();
                try {
                    child.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                FileOutputStream fos = new FileOutputStream(fileName);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Starting child");
            try {
                child = Runtime.getRuntime().exec(exec);
                new StreamWriter(child.getInputStream(), System.out);
                new StreamWriter(child.getErrorStream(), System.err);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closing(int rc) {
        synchronized (this) {
            notifyAll();
        }
    }

    public void process(WatchedEvent watchedEvent) {
        dataMonitor.process(watchedEvent);
    }

    static class StreamWriter extends Thread {
        OutputStream os;
        InputStream is;

        StreamWriter(InputStream is, OutputStream os) {
            this.os = os;
            this.is = is;
            start();
        }

        public void run() {
            byte[] b = new byte[80];
            int rc;
            try {
                while((rc = is.read()) > 0) {
                    os.write(b, 0, rc);
                }
            } catch (IOException e) {
            }
        }

    }
}
