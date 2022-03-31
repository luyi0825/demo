package com.example.spring.transaction;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author luyi
 */
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransactionService transactionService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrder(int count) {
        String insertOrderSql = "insert into t_order(count) values(?)";
        jdbcTemplate.update(insertOrderSql, new Object[]{count});
        reduceCount(count);
    }

    @Override
    public void reduceCount(int count) {
        System.out.println(1 / 0);
        String updateSql = "update t_count set count=count-1 where id=1";
        jdbcTemplate.update(updateSql);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testPrivate() {
        myPrivate1();
        myPrivate2();
    }


    private void myPrivate1() {
        String name = UUID.randomUUID().toString();
        String sql = "insert into t_user (name) values (?)";
        jdbcTemplate.update(sql, name);
    }

    private void myPrivate2() {
        String name = UUID.randomUUID().toString();
        if (true) {
            throw new RuntimeException();
        }
        String sql = "insert into t_user (name) values (?)";
        jdbcTemplate.update(sql, name);
    }

    public static void main(String[] args) {
        double test = 999;
        System.out.println(test);
    }


    @Override
    public void testPublic() {
        myPublic();
    }

    @Override
    @Transactional
    public void myPublic() {
        String sql = "insert into t_user (name) values (?)";
        String name = UUID.randomUUID().toString();
        jdbcTemplate.update(sql, name);
        //int a=1/0;
        jdbcTemplate.update(sql, name);
    }

}
