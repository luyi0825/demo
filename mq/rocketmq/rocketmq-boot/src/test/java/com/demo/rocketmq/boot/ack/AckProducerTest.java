package com.demo.rocketmq.boot.ack;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AckProducerTest {
    @Resource
    private AckProducer ackProducer;

    @Test
    void sendMessage() {
        for (int i = 0; i < 100; i++) {
            ackProducer.sendMessage("ack" + i);
        }
    }
}