package com.test.jvm;

/**
 * @author zhoupei
 * @date 2021/11/26
 **/
public class Tableware {
    private static Bowl bowl7 = new Bowl(7);

    static {
        System.out.println("餐具的静态方法.");
    }

    public Tableware() {
        System.out.println("餐具的构造方法.");
    }

    private Bowl bowl6 = new Bowl(6);
}
