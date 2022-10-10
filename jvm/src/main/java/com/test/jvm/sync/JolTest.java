package com.test.jvm.sync;

import org.openjdk.jol.info.ClassLayout;

public class JolTest {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Test();
        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }

   static class Test {
        private long p;
    }
}
