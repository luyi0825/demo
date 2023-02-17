package com.test.jvm.thread;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("1");
        System.gc();
        System.out.println(threadLocal.get());
    }

}
