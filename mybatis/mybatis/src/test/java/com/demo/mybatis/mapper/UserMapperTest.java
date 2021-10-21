package com.demo.mybatis.mapper;

import com.demo.mybatis.entity.AuthUser;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserMapperTest {


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void scan() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int i = 0;
        Cursor<AuthUser> authUserList = sqlSession.getMapper(UserMapper.class).scan(10000);
        for (AuthUser authUser : authUserList) {
            System.out.println(authUser + ":" + (++i));
        }
        sqlSession.close();
    }
}