package com.test.jvm.juc.aqs;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SemaphoneTest {
    /**
     * 实现一个同时只能处理5个请求的限流器
     */
    private static Semaphore semaphore = new Semaphore(5);

    /**
     * 定义一个线程池
     */
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(200));

    /**
     * 模拟执行方法
     */
    public static void exec() {
        try {

            // 模拟真实方法执行
            System.out.println("执行exec方法");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        {
            // 模拟请求以10个/s的速度
            for (; ; ) {
                Thread.sleep(100);
                boolean canExec = semaphore.tryAcquire(1);

                if (canExec) {
                    executor.execute(() -> {
                        try {
                            exec();
                        } finally {
                            semaphore.release(1);
                        }
                    });
                } else {
                    System.out.println("请求拒绝");
                }
            }
        }
    }
}
