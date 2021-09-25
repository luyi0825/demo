package com.test.rabbitmq.topic;

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
 */
@Component
public class Topic {
    public static final String EXCHANGE_NAME="test_topic";
    @RabbitListener(bindings = {@QueueBinding(value = @Queue("test_topic_queue1"),
            exchange = @Exchange(value = EXCHANGE_NAME,type = ExchangeTypes.TOPIC), key = {"info", "error","*.info"})})
    public void all(Message message, Channel channel) throws IOException {
        System.out.println("topic_all:"+new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue("test_topic_queue2"),
            exchange = @Exchange(value = EXCHANGE_NAME,type = ExchangeTypes.TOPIC), key = {"error"})})
    public void error(Message message,Channel channel) throws IOException {
        System.out.println("topic_error:"+new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
