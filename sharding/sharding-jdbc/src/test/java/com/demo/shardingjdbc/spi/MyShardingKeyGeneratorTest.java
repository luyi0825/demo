package com.demo.shardingjdbc.spi;

import com.demo.shardingjdbc.dao.UserDao;
import com.demo.shardingjdbc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

@SpringBootTest
@ActiveProfiles("shardingkey")
class MyShardingKeyGeneratorTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("username" + UUID.randomUUID());
        user.setPassword("password" + UUID.randomUUID());
        user.setMail("893431435@qq.com");
        userDao.insert(user);

    }

}