package com.test.jvm.thread;

public class TestWait2 {
    static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        object.wait(5000);
        System.out.println(1);

    }
}
