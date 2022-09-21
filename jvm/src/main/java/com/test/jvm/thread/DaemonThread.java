package com.test.jvm.thread;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("线程正在执行...");
                }
            }
        });
        t.setDaemon(true);
        t.start();
        Thread.sleep(5);
    }
}
