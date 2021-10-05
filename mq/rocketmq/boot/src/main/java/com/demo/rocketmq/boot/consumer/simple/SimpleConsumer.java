package com.demo.rocketmq.boot.consumer.simple;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author luyi
 */
@RocketMQMessageListener(consumerGroup = "test", topic = "springBoot")
@Component
public class SimpleConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {
        System.out.println(message);
    }
}
