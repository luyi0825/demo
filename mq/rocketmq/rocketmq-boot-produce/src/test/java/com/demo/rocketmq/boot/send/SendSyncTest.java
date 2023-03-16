package com.demo.rocketmq.boot.send;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
public class SendSyncTest {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    void sendSendSync() {
        rocketMQTemplate.convertAndSend("send_sync", UUID.randomUUID());
    }
}
