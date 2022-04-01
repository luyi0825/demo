package com.demo.mybatis.son.mapper;


import com.demo.mybatis.son.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;


/**
 * @author luyi
 */
public interface UserMapper {

    User selectById(@Param("id") int id);

}
