package com.test.rabbitmq.works;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.test.rabbitmq.RabbitMqUtils;
import com.test.rabbitmq.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;


class WorkConsumerTest {


    @Test
    public void send() throws IOException, TimeoutException {

        Channel channel= RabbitMqUtils.getConnection().createChannel();

        ObjectMapper objectMapper=new ObjectMapper();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setUsername("test:" + i);
            channel . basicPublish("",WorkConsumer.WORK_QUEUE,null,objectMapper.writeValueAsBytes(user));
        }
    }

}