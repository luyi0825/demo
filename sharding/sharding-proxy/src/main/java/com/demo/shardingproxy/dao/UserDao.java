package com.demo.shardingproxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.shardingproxy.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luyi
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
