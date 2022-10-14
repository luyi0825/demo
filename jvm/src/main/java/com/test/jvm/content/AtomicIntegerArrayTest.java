package com.test.jvm.content;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
   volatile static int[] value = new int[]{1, 2, 3, 4, 5};
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);


    public static void main(String[] args) throws InterruptedException {

        //设置索引0的元素为100
        atomicIntegerArray.set(0, 100);
        System.out.println(atomicIntegerArray.get(0));
        //100线程，对下标为1的都累加1
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicIntegerArray.addAndGet(1, 1);
                }
            }).start();
        }


        System.out.println(atomicIntegerArray);
    }
}
