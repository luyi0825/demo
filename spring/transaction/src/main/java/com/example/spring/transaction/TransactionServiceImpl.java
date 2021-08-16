package com.example.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author luyi
 */
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrder(int count) {
        String insertOrderSql = "insert into t_order(count) values(?)";
        jdbcTemplate.update(insertOrderSql, new Object[]{count});
        reduceCount(count);
    }

    @Override
    public void reduceCount(int count) {
        System.out.println(1/0);
        String updateSql = "update t_count set count=count-1 where id=1";
        jdbcTemplate.update(updateSql);
    }
}
