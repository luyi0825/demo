package com.demo.rocketmq.boot.simple;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * @author luyi
 * 同步发送消息
 */
@Component
public class AsyncProducer {

    @Autowired
    private RocketMQTemplate rocketMqTemplate;

    public void send() {
        rocketMqTemplate.convertAndSend("test async message");
    }

}
