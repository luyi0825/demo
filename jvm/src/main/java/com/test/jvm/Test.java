package com.test.jvm;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(16>>>2);
        long count = 1000000L;
        //testNew(count);
        //testClone(count);
    }

    private static void testClone(long count) throws CloneNotSupportedException {
        Entity entity = new Entity();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Entity entity1 = entity.clone();
        }
        System.out.println("clone" + (System.currentTimeMillis() - startTime));
    }

    private static void testNew(long count) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Entity entity1 = new Entity();
        }
        System.out.println("new" + (System.currentTimeMillis() - startTime));
    }
}
