package com.test.rabbitmq.topic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.test.rabbitmq.RabbitMqUtils;
import com.test.rabbitmq.routing.Routing;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class TopicTest {

    @Test
    public void send() throws IOException, TimeoutException {
        Map<String, String> map = new HashMap<>();
        map.put("error", "错误");
        map.put("info", "提示info");
        map.put("my.info", "提示-myinfo");
        Channel channel = RabbitMqUtils.getConnection().createChannel();
        map.forEach((key, value) -> {
            try {
                Map<String,String> message=new HashMap<>(1);
                message.put("message",value);
                channel.basicPublish(Topic.EXCHANGE_NAME, key, null, new ObjectMapper().writeValueAsBytes(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}