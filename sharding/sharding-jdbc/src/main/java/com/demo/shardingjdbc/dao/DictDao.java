package com.demo.shardingjdbc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.shardingjdbc.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luyi
 * 字段
 */
@Mapper
public interface DictDao extends BaseMapper<Dict> {
}
