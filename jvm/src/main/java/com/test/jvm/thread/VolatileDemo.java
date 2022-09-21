package com.test.jvm.thread;

/**
 * @author luyi
 */
public class VolatileDemo {
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (flag) {
                        System.out.println("turn on");
                        flag = false;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!flag) {
                        System.out.println("turn off");
                        flag = true;
                    }
                }
            }
        }).start();
    }
}