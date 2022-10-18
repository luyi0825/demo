package com.test.jvm.sync;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static void main(String[] args) {
        User user = new User();
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    userAtomicReference.set(null);
                }
            }).start();
        }
    }

    static class User {
        int count;
    }

}
