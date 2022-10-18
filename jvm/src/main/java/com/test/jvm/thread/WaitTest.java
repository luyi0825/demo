package com.test.jvm.thread;

public class WaitTest {
    public void testWaitMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin wait()");
                // wait() 释放锁资源
                Thread.sleep(5000);
                lock.wait();
                System.out.println(Thread.currentThread().getName() + " end wait()");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    public void testNotifyMethod(Object lock) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " begin notify()");
            lock.notify();
            System.out.println(Thread.currentThread().getName() + " end notify()");

        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        WaitTest test = new WaitTest();
        Thread t1 = new Thread(new Runnable() {
            @Override

            public void run() {
                test.testWaitMethod(lock);

            }
        }, "threadA");
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override

            public void run() {
                test.testNotifyMethod(lock);

            }
        }, "threadB");
        t2.start();
        try {
            Thread.sleep(500000);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
