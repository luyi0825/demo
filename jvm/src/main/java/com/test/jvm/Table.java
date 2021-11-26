package com.test.jvm;

/**
 * @author zhoupei
 * @date 2021/11/26
 **/
public class Table extends Tableware{
    static {
        System.out.println("桌子静态代码块1.");
    }
    private Bowl bowl5 = new Bowl(5);

    static {
        System.out.println("桌子静态代码块2.");
    }
    private static Bowl bowl4 = new Bowl(4);

    static {
        System.out.println("桌子静态代码块3.");
    }
    public Table() {
        System.out.println("桌子构造方法.");
    }
    private static Bowl bowl3 = new Bowl(3);
}
