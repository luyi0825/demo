package com.test.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RabbitMqConfirmTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send() {
        User user = new User();
        rabbitTemplate.convertAndSend(UUID.randomUUID().toString(),UUID.randomUUID().toString(), user);
        rabbitTemplate.convertAndSend(UUID.randomUUID().toString());
        System.out.println("");
    }

}