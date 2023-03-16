package com.demo.rocketmq.boot.ack;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author luyi
 * 应答生产者
 */
@Component
public class AckProducer {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendMessage(String s) {
        // rocketMQTemplate.convertAndSend("test-spring-boot",message);
        Message message = new Message();
        message.setTopic("test-spring-boot");
        message.setKeys(UUID.randomUUID().toString());
        rocketMQTemplate.syncSend("test-spring-boot", message);
    }
}
