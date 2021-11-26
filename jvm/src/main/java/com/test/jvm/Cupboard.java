package com.test.jvm;

/**
 * @author zhoupei
 * @date 2021/11/26
 **/
public class Cupboard extends Tableware{
    private Bowl bowl2 = new Bowl(2);
    private static Bowl bowl1 = new Bowl(1);

    public Cupboard() {
        System.out.println("碗柜的构造方法.");
    }
    public void otherMethod(int mark){
        System.out.println("其他方法" + mark);
    }
    private static Bowl bowl0 = new Bowl(0);
}
