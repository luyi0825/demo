package com.test.mongo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

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