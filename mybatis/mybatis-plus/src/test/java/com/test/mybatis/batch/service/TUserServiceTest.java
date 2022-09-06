package com.test.mybatis.batch.service;

import com.test.mybatis.batch.domain.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class TUserServiceTest {

    @Resource
    private TUserService userService;

    @Test
    void findById() {
        userService.getById("1");
    }

    @Test
    public void batchInsert() {
        List<TUser> userList = new ArrayList<>();
        int size = 100_000;
        for (int i = 0; i < size; i++) {
            TUser tUser = new TUser();
            tUser.setName(UUID.randomUUID().toString());
            tUser.setPassword("password");
            tUser.setAge(18);
            userList.add(tUser);
        }
        long startTime = System.currentTimeMillis();
        // userService.saveBatch(userList,size);
        userService.saveOrUpdateBatch(userList);
        System.out.println(System.currentTimeMillis() - startTime);


    }
}
