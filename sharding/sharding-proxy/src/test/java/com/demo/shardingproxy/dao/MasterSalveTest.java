package com.demo.shardingproxy.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.model.dao.UserDao;
import com.demo.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 主从-读写分离测试
 */
@SpringBootTest
//@ActiveProfiles("masterslave1")
//@ActiveProfiles("masterslave2")
public class MasterSalveTest {

    @Resource
    private UserDao userDao;

    @Test
    public void test() {
        User user = new User();
        String username = "username" + UUID.randomUUID();
        user.setUsername(username);
        user.setPassword("password" + UUID.randomUUID());
        user.setMail("893431435@qq.com");
        userDao.insert(user);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        user = userDao.selectOne(queryWrapper);
        Assertions.assertNotNull(user);
        System.out.println(user);
    }

}
