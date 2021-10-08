package com.demo.shardingjdbc.dao;

import com.demo.shardingjdbc.entity.Dict;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
class DictDaoTest {
    @Autowired
    private DictDao dictDao;

    /**
     * 测试广播表
     */
    @Test
    public void broadcast() {
        Dict dict = new Dict();
        dict.setCode(UUID.randomUUID().toString());
        dict.setCaption(dict.getCode());
        dictDao.insert(dict);
    }

}