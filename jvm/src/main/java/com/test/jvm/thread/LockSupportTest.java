package com.test.jvm.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport测试
 * @author luyi
 *
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread parkThread = new Thread(new ParkThread());


        parkThread.start();
        LockSupport.unpark(parkThread);
        System.out.println("唤醒parkThread");

    }

    static class ParkThread implements Runnable {
        @Override
        public void run() {
            System.out.println("ParkThread开始执行");
            LockSupport.park();
            System.out.println("ParkThread执行完成");
        }
    }
}