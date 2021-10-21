package com.demo.mybatis.mapper;


import com.demo.mybatis.entity.AuthUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;


/**
 * @author luyi
 */
public interface UserMapper {

    @Select("select * from t_auth_user order by id limit #{limit} ")
    Cursor<AuthUser> scan(@Param("limit") long limit);

}
