package com.test.jvm.cas;

import com.test.jvm.Entity;
import sun.misc.Unsafe;

/**
 * @author luyi
 */
public class CasTest {

    public static void main(String[] args) {

        System.out.println( Math.random());

        Entity entity = new Entity();

        Unsafe unsafe = UnsafeFactory.getUnsafe();

        long offset = UnsafeFactory.getFieldOffset(unsafe, Entity.class, "x");

        boolean successful;

        // 4个参数分别是：对象实例、字段的内存偏移量、字段期望值、字段新值
        successful = unsafe.compareAndSwapInt(entity, offset, 0, 3);
        //true 3
        System.out.println(successful + "\t" + entity.getX());

        successful = unsafe.compareAndSwapInt(entity, offset, 3, 5);
        //true 5
        System.out.println(successful + "\t" + entity.getX());

        successful = unsafe.compareAndSwapInt(entity, offset, 3, 8);
        //false 5
        System.out.println(successful + "\t" + entity.getX());
    }
}

