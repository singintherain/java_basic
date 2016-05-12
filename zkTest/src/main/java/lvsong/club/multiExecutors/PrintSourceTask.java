package lvsong.club.multiExecutors;

/**
 * Created by lvsong on 5/5/16.
 */
public class PrintSourceTask implements Runnable {
    private MultiThreadGetZkNodeData multiThreadGetZkNodeData;

    public PrintSourceTask(MultiThreadGetZkNodeData multiThreadGetZkNodeData) {
        this.multiThreadGetZkNodeData = multiThreadGetZkNodeData;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("source--" + multiThreadGetZkNodeData.getSource());

            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
