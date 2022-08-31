package com.demo.sql.dynamic.service;

import com.demo.sql.dynamic.datasource.DataSourceKeyHolder;
import com.demo.sql.dynamic.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void insert() {
        DataSourceKeyHolder.set("test1");
        UserEntity userEntity = new UserEntity();
        String uuid = UUID.randomUUID().toString();
        userEntity.setUsername(uuid);
        userEntity.setPassword(uuid);
        userService.insert(userEntity);
    }

}