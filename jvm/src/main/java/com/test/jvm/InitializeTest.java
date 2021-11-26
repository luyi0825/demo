package com.test.jvm;

/**
 * 父类静态变量（静态代码块）->
 * 子类静态变量（静态代码块）->
 * 父类非静态变量（非静态代码块）->
 * 父类构造器 ->
 * 子类非静态变量（非静态代码块）->
 * 子类构造器 。
 * @author zhoupei
 * @date 2021/11/26
 **/
public class InitializeTest {
    /**
     * https://zhuanlan.zhihu.com/p/34671512
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main");
        cupboard.otherMethod(1);
    }
    private static Table table = new Table();
    private static Cupboard cupboard = new Cupboard();

    /**
     * 餐具的静态
     * 1. 第7个碗
     * 2. 餐具的静态方法
     *
     * 桌子静态
     * 3. 桌子静态代码块1
     * 4. 桌子静态代码块2
     * 5. 第4个碗
     * 6. 桌子静态代码块3
     * 7. 第3个碗
     *
     * 餐具非静态
     * 8. 第6个碗
     *
     * 餐具构造
     * 9. 餐具的构造方法
     *
     * 桌子非静态
     * 10. 第5个碗
     *
     * 桌子构造
     * 11. 桌子构造方法
     *
     * 碗柜静态
     * 12. 第1个碗
     * 13. 第0个碗
     *
     * 餐具非静态
     * 14. 第6个碗
     *
     * 餐具构造
     * 15. 餐具的构造方法
     *
     * 碗柜非静态
     * 16. 第2个碗
     *
     * 碗柜构造
     * 17. 碗柜的构造方法
     *
     * 调用
     * 18. 其他方法1
     */
}
