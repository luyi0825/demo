package com.test.rabbitmq.delayqueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.test.rabbitmq.RabbitMqUtils;
import com.test.rabbitmq.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class DelayQueueTest {

    @Test
    public void send() throws IOException, TimeoutException {
        for (int i = 0; i < 20; i++) {
            Channel channel = RabbitMqUtils.getConnection().createChannel();
            User user = new User();
            user.setUsername("Delay");
            channel.basicPublish(DelayQueueConfig.NORMAL_DELAY_EXCHANGE, "test.dlx.#", null, new ObjectMapper().writeValueAsBytes(user));
        }

    }


}