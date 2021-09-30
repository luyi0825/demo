package com.test.mongo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.UUID;

@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void test() {
        //user为查询出来的数据
        User user = new User();
        user.setId("test");
        user.setUserName("123");
        user.setPassword("123");

        userDao.insert(user);
        //模仿默认线程1save
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        user1.setPassword("345");
        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        user2.setSex("男");
        //模仿默认线程2save
        userDao.save(user1);
        userDao.save(user2);

    }


    @Test
    public void insertOne() {
        //39943 37639|59554|59777
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            //user.setId(UUID.randomUUID().toString());
            user.setUserName(UUID.randomUUID().toString());
            userDao.insert(user);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void findByName() {
        long startTime = System.currentTimeMillis();
        userDao.findByUserName(UUID.randomUUID().toString());
        System.out.println(System.currentTimeMillis() - startTime);
    }


}