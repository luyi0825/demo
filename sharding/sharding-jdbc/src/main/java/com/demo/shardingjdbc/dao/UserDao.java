package com.demo.shardingjdbc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.shardingjdbc.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luyi
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
