package com.lvsong;

/**
 * Created by lvsong on 3/26/16.
 */
public class NotifyTest {
    static class Source {
        private int num = 1;

        public void get() throws InterruptedException {
            synchronized (this) {
                while (num <= 0) {
                    System.out.println("source get block");
                    wait();
                }

                num --;
                System.out.println("get: " + num);
            }
        }

        public void release() {
            synchronized (this) {
                num ++;

                System.out.println("release source, notify all");
                System.out.println("release: " + num);
                notifyAll();
            }
        }
    }

    static class Task1 implements Runnable {
        private Source source;

        public Task1(Source source) {
            this.source = source;
        }

        @Override
        public void run() {
            try {
                source.get();
                System.out.println("source get success");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Task2 implements Runnable {
        private Source source;

        public Task2(Source source) {
            this.source = source;
        }

        @Override
        public void run() {
            source.release();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Source source = new Source();
        Thread getTask = new Thread(new Task1(source));
        Thread getTask1 = new Thread(new Task1(source));
        Thread getTask2 = new Thread(new Task1(source));
        Thread getTask3 = new Thread(new Task1(source));
        Thread releaseTask = new Thread(new Task2(source));

        getTask.start();
        getTask1.start();
        getTask2.start();
        getTask3.start();
        releaseTask.start();

//        Thread.currentThread().sleep(5000);
    }
}
