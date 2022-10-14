package com.test.jvm.content;

/**
 * 原子性测试
 *
 * @author luyi
 */
public class AtomicityTest {


    public static void main(String[] args) {
        long a = 1, b = 1;
        a++;
        ++b;
        System.out.println(a);
        System.out.println(b);
    }


}
