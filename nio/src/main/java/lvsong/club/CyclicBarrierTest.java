package lvsong.club;

import java.util.concurrent.*;

/**
 * Created by lvsong on 3/5/16.
 */
public class CyclicBarrierTest {
//    public static CyclicBarrier barrier = new CyclicBarrier(3);
    public static CountDownLatch barrier = new CountDownLatch(3);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Thread(new Runner("1号选手")));
        executorService.submit(new Thread(new Runner("2号选手")));
        executorService.submit(new Thread(new Runner("3号选手")));

        executorService.shutdown();
    }
}

    class Runner implements Runnable {
        private String name;

        public Runner(String name) {
            this.name = name;
        }

        public void run() {
            for(int i = 0; i < 3; i++) {
                System.out.println(name + "准备好了。");

                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                try {
//                    CyclicBarrierTest.barrier.await();
                    CyclicBarrierTest.barrier.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }

                System.out.println(name + "开始跑步。");

                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(name + "休息1秒钟");
            }

        }

    }

