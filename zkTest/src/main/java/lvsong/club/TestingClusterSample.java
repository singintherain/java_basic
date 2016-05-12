package lvsong.club;

import org.apache.curator.test.TestingCluster;
import org.apache.curator.test.TestingZooKeeperServer;

/**
 * Created by lvsong on 5/4/16.
 */
public class TestingClusterSample {
    public static void main(String[] args) throws Exception {
        TestingCluster cluster = new TestingCluster(3);
        cluster.start();
        Thread.sleep(2000);

        TestingZooKeeperServer leader = null;

        for(TestingZooKeeperServer zooKeeperServer : cluster.getServers()) {
            System.out.print(zooKeeperServer.getInstanceSpec().getServerId() + "-");
            System.out.print(zooKeeperServer.getQuorumPeer().getServerState() + "-");
            System.out.print(zooKeeperServer.getInstanceSpec().getDataDirectory().getAbsolutePath());

            if(zooKeeperServer.getQuorumPeer().getServerState().equals("leading")) {
                leader = zooKeeperServer;
            }

            System.out.println();
        }

        System.out.println("Before leader kill");
        leader.kill();

        System.out.println("After leader kill: ");

        for(TestingZooKeeperServer zooKeeperServer : cluster.getServers()) {
            System.out.print(zooKeeperServer.getInstanceSpec().getServerId() + "-");
            System.out.print(zooKeeperServer.getQuorumPeer().getServerState() + "-");
            System.out.print(zooKeeperServer.getInstanceSpec().getDataDirectory().getAbsolutePath());
        }

        cluster.stop();
    }
}
