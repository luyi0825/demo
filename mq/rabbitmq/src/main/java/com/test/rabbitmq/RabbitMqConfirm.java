package com.test.rabbitmq;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author luyi
 */
@Configuration
public class RabbitMqConfirm {

    @Autowired
    public RabbitMqConfirm(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> System.out.println(ack)));

        rabbitTemplate.setReturnsCallback(returned -> {
                    System.out.println(returned.getMessage());
                    System.out.println(returned.getReplyCode());
                    System.out.println(returned.getReplyText());
                }
        );
    }


}
