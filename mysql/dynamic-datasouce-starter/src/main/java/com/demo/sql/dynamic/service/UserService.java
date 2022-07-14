package com.demo.sql.dynamic.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.demo.sql.dynamic.entity.UserEntity;
import com.demo.sql.dynamic.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author luyi
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;


    public void insert(UserEntity userEntity) {
        userMapper.insert(userEntity);
    }
}
