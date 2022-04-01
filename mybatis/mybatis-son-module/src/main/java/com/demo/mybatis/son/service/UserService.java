package com.demo.mybatis.son.service;

import com.demo.mybatis.son.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author luyi
 */
@Service
public interface UserService {

    User selectById(int id);
}
