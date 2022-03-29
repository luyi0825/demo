package com.demo.rocketmq.boot.consumer.simple;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author luyi
 */
@RocketMQMessageListener(consumerGroup = "test", topic = "springBoot", consumeMode = ConsumeMode.ORDERLY)
@Component
public class OrderConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {
        System.out.println("得到顺序消息：" + message);
    }
}
