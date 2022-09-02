package com.test.jvm.thread;

import cn.hutool.core.util.IdcardUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(IdcardUtil.isValidCard("420620196807141044"));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        Thread.sleep(1000);
    }
}
