package com.demo.sql.dynamic.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void insert() {
        userService.insert(null);
    }

}