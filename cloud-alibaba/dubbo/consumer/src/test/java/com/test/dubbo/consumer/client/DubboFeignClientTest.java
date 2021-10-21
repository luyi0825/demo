package com.test.dubbo.consumer.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DubboFeignClientTest {

    @Autowired
    private DubboFeignClient dubboFeignClient;


    @Test
    void sayHello() {
        for (int i = 0; i < 3; i++) {
            System.out.println(dubboFeignClient.sayHello());
        }
    }
}