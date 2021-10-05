package com.demo.rocketmq.boot.consumer.simple;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author luyi
 */
@Component
public class SimpleProduct {

    @Autowired
    private RocketMQTemplate rocketMqTemplate;


    public void send() {
       String message="tes22t";
        rocketMqTemplate.convertAndSend("springBoot", message);
    }
}
