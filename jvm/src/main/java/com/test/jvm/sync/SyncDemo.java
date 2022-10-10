package com.test.jvm.sync;

/**
 * @author luyi
 */
public class SyncDemo {
    private static int counter = 0;

    public  static void increment() {
        counter++;
        ++counter;
    }

    public static void decrement() {
        --counter;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                decrement();
            }
        }, "t2");
        t1.start();
        t2.start();
        //让两个线程执行完毕
        t1.join();
        t2.join();

        //思考： counter=?
        System.out.println(counter);
    }
}
