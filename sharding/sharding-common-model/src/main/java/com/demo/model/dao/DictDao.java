package com.demo.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.model.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luyi
 * 字段
 */
@Mapper
public interface DictDao extends BaseMapper<Dict> {
}
