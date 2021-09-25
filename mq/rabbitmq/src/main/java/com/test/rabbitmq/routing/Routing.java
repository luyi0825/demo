package com.test.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author luyi
 * 路由
 */
@Component
public class Routing {
    public static final String EXCHANGE_NAME = "exchange_route_test";

    @RabbitListener(bindings = {@QueueBinding(value = @Queue("routing_queue1"),
            exchange = @Exchange(value = EXCHANGE_NAME, type = ExchangeTypes.DIRECT), key = {"info", "error"})})
    public void all(Message message, Channel channel) throws IOException {
        System.out.println("Routing_all:" + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue("routing_queue2"),
            exchange = @Exchange(value = EXCHANGE_NAME, type = ExchangeTypes.DIRECT), key = {"error"})})
    public void error(Message message, Channel channel) throws IOException {
        System.out.println("Routing_error:" + new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }


}
