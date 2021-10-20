package com.demo.cloud.openfeign.consumer.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenFeignClientTest {

    @Autowired
    private OpenFeignClient openFeignClient;

    @Test
    public void sayHello() {
        for (int i = 0; i < 3; i++) {
            String str = openFeignClient.sayHello();
            System.out.println(str);
        }
    }


}