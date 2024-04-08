package com.demo.elasticsearch;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Executors.newCachedThreadPool().execute(new MyThread(new User()));
    }

    static class MyThread extends Thread {
        private User user;

        public MyThread(User user) {
            System.out.println(Thread.currentThread());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            System.out.println("1");
        }
    }

    static class User {
        public User() {
            System.out.println(Thread.currentThread());
        }
    }
}
