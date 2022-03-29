package com.demo.rocketmq.boot.consumer.simple;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author luyi
 */
@Component
public class SimpleProduct {

    @Autowired
    private RocketMQTemplate rocketMqTemplate;

    private static final Logger logger = LoggerFactory.getLogger(SimpleProduct.class);


    private static final String DESTINATION = "springBoot";

    /**
     * 同步发送
     *
     * @param message
     */
    public void send(String message) {
        rocketMqTemplate.convertAndSend(DESTINATION, message);
    }

    /**
     * 异步发送
     */
    public void sendAsync(String message) {

        rocketMqTemplate.asyncSend(DESTINATION, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                SendStatus sendStatus = sendResult.getSendStatus();
                System.out.println(sendStatus);
            }

            @Override
            public void onException(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }

    public void sendOneWay(String message) {
        rocketMqTemplate.sendOneWay("springBoot", message);
    }

    public void sendOrder(String message) {
        rocketMqTemplate.syncSendOrderly(DESTINATION, message, "1");
    }
}
