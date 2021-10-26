package com.demo.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luyi
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
