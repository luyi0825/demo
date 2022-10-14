package com.test.jvm.concurrency;

/**
 * 线程中断测试
 *
 * @author luyi
 */
public class InterruptTest implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count = " + count++);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程停止： stop thread");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptTest());
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }
}
