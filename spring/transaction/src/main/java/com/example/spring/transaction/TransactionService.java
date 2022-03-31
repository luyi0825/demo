package com.example.spring.transaction;

public interface TransactionService {
    /**
     * 添加订单
     */
    void addOrder(int count);

    /**
     * 减少库存
     */
    void reduceCount(int count);

    /**
     * 测试私有，注解在公共方法上
     */
    void testPrivate();
    /**
     * 测试public，注解在内部调用
     */
    void testPublic();

    void myPublic();
}
