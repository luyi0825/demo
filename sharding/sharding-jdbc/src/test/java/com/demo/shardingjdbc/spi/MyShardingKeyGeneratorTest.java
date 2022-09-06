package com.demo.shardingjdbc.spi;


import com.demo.model.dao.UserDao;
import com.demo.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("shardingkey")
class MyShardingKeyGeneratorTest {
    @Resource
    private UserDao userDao;

    @Value("${test}")
    private String test;

    @Test
    public void test() {
        System.out.println(test);
        User user = new User();
        user.setUsername("username" + UUID.randomUUID());
        user.setPassword("password" + UUID.randomUUID());
        user.setMail("893431435@qq.com");
        userDao.insert(user);
    }

}