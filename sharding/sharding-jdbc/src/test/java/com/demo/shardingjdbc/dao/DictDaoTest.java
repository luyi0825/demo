package com.demo.shardingjdbc.dao;

import com.demo.model.dao.DictDao;
import com.demo.model.entity.Dict;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;


@SpringBootTest
class DictDaoTest {
    @Resource
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