package com.test.rabbitmq.publishsubscribe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.test.rabbitmq.RabbitMqUtils;
import com.test.rabbitmq.User;
import com.test.rabbitmq.works.WorkConsumer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class PublishSubscribeTest {

    @Test
    public void send() throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getConnection().createChannel();

        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("test:" + i);
            channel.basicPublish(PublishSubscribeConstants.EXCHANGE, "test1", null, objectMapper.writeValueAsBytes(user));
        }
    }

}