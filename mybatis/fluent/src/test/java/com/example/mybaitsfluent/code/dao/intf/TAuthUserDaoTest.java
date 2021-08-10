package com.example.mybaitsfluent.code.dao.intf;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TAuthUserDaoTest {

    @Autowired
    private TAuthUserDao tAuthUserDao;

    @Test
    public void test(){
        tAuthUserDao.selectById("1");
    }

}