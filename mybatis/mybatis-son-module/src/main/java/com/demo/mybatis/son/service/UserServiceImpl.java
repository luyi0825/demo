package com.demo.mybatis.son.service;

import com.demo.mybatis.son.entity.User;
import com.demo.mybatis.son.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User selectById(int id) {
        return userMapper.selectById(id);
    }
}
