package com.demo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author luyi
 * 集群测试
 */
@SpringBootTest
public class ClusterTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.getClientList();
        for (int i = 0; i < 10000; i++) {
            stringRedisTemplate.opsForValue().set(i + "", i + "");
        }
    }

}
