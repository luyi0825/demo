package com.test.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.test.rabbitmq.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


@SpringBootTest
class HelloWorldTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendHelloWorld() throws IOException, TimeoutException {
        User user = new User();
        user.setUsername("test");
        rabbitTemplate.convertAndSend(HelloWorld.HELLO_WORLD_QUEUE, user);
    }


}