package com.test.jvm.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        System.out.println("开始时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        //scheduledThreadPoolExecutor.schedule(new MyTask(), 5, TimeUnit.SECONDS);
         scheduledThreadPoolExecutor.scheduleAtFixedRate(new MyTask(), 4, 1, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new MyTask(5000), 5, 1, TimeUnit.SECONDS);
    }

    static class MyTask implements Runnable {

        int sleepTime;

        public MyTask() {

        }

        public MyTask(int sleepTime) {
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            //Thread.sleep(5000L+sleepTime);
            System.out.println("执行任务：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }
}
