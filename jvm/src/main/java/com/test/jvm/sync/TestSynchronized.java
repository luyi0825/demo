package com.test.jvm.sync;

/**
 * @author luyi
 */
public class TestSynchronized {
    public static void main(String[] args) {
        System.out.println("main");
    }

    public synchronized void sayHello() {
        System.out.println("hello");
    }

    public static synchronized void sayHello2() {
        System.out.println("hello2");
    }
}
