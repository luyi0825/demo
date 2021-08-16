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
}
