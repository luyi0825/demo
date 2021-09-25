package com.test.rabbitmq.routing;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.test.rabbitmq.RabbitMqUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

class RoutingTest {

    @Test
    public void send() throws IOException, TimeoutException {
        Map<String, String> map = new HashMap<>();
        map.put("error", "错误");
        map.put("info", "提示");
        Channel channel = RabbitMqUtils.getConnection().createChannel();
        map.forEach((key, value) -> {
            try {
                Map<String,String> message=new HashMap<>(1);
                message.put("message",value);
                channel.basicPublish(Routing.EXCHANGE_NAME, key, null, new ObjectMapper().writeValueAsBytes(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}