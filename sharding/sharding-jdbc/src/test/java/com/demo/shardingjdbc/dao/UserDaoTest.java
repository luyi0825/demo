package com.demo.shardingjdbc.dao;

import com.demo.shardingjdbc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
class UserDaoTest {

    @Autowired(required = false)
    private UserDao userDao;

    @Test
    public void insert() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUsername("username" + UUID.randomUUID().toString());
            user.setPassword("password" + UUID.randomUUID().toString());
            user.setMail("893431435@qq.com");
            userDao.insert(user);
        }

    }
}