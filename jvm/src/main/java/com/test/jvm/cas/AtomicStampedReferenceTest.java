package com.test.jvm.cas;

import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;


/**
 * @author luyi
 */
public class AtomicStampedReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        // 定义AtomicStampedReference    Pair.reference值为1, Pair.stamp为1
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);

        new Thread(() -> {
            int value = atomicStampedReference.getReference();
            int stamp = atomicStampedReference.getStamp();
            System.out.println("Thread1 read value: " + value + ", stamp: " + stamp);

            // 阻塞1s
            LockSupport.parkNanos(1000000000L);
            // Thread1通过CAS修改value值为3
            if (atomicStampedReference.attemptStamp(2, stamp + 1)) {
                System.out.println("Thread1 update from " + value + " to 3");
            } else {
                System.out.println("Thread1 update fail!");
            }
        }, "Thread1").start();
        Thread.sleep(1);
        new Thread(() -> {

            int value = atomicStampedReference.getReference();
            int stamp = atomicStampedReference.getStamp();
            System.out.println("Thread2 read value: " + value + ", stamp: " + stamp);
            // Thread2通过CAS修改value值为2
            if (atomicStampedReference.compareAndSet(value, 2, stamp, stamp + 1)) {
                System.out.println("Thread2 update from " + value + " to 2");

                // do something

                value =  atomicStampedReference.getReference();
                stamp = atomicStampedReference.getStamp();
                System.out.println("Thread2 read value: " + value + ", stamp: " + stamp);
                // Thread2通过CAS修改value值为1
                if (atomicStampedReference.compareAndSet(value, 1, stamp, stamp + 1)) {
                    System.out.println("Thread2 update from " + value + " to 1");
                }
            }
        }, "Thread2").start();
    }
}