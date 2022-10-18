package com.test.jvm.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock重入测试
 * @author luyi
 */
public class ReentrantLockReentryTest {
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        method1();
    }


    public static void method1() {
        lock.lock();
        try {
            System.out.println("execute method1");
            method2();
        } finally {
            lock.unlock();
        }
    }
    public static void method2() {
        lock.lock();
        try {
            System.out.println("execute method2");
            method3();
        } finally {
            lock.unlock();
        }
    }
    public static void method3() {
        lock.lock();
        try {
            System.out.println("execute method3");
        } finally {
            lock.unlock();
        }
    }
}
