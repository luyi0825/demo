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
        for (int i = 0; i < 100; i++) {
            simpleProduct.send("send" + i);
        }

    }

    @Test
    void sendAsync() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            simpleProduct.sendAsync("sendAsync" + i);
        }
        Thread.sleep(5000L);
    }

    @Test
    void sendOneWay() {
        for (int i = 0; i < 100; i++) {
            simpleProduct.sendOneWay("sendOneWay" + i);
        }
    }

    @Test
    public void sendOrder(){
        for (int i = 0; i < 10000; i++) {
            simpleProduct.sendOrder("sendOrder" + i);
        }
    }
}