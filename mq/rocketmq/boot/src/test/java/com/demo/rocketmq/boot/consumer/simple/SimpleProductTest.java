package com.demo.rocketmq.boot.consumer.simple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SimpleProductTest {

    @Autowired
    private SimpleProduct simpleProduct;

    @Test
    public void send() {
        simpleProduct.send();
    }

}