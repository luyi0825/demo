package com.test.mybatis.batch.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TUserServiceTest {

    @Resource
    private TUserService userService;

    @Test
    void findById() {
        userService.getById("1");
    }
}
