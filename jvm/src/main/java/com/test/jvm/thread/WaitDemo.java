package com.test.jvm.thread;

public class WaitDemo {
    private static final Object lock = new Object();
    private static boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (flag) {
                        try {
                            System.out.println("wait start .......");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("wait end ....... ");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (flag) {
                    synchronized (lock) {
                        if (flag) {
                            lock.notify();
                            System.out.println("notify .......");
                            flag = false;
                        }
                    }
                }
            }
        }).start();
    }
}