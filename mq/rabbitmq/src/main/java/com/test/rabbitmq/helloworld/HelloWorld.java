package com.test.rabbitmq.helloworld;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author luyi
 */
@Component
public class HelloWorld {


    public static final String HELLO_WORLD_QUEUE = "hello_world_queue";

    @RabbitListener(queuesToDeclare = {@Queue(name = HelloWorld.HELLO_WORLD_QUEUE)})
    public void process(Message message, Channel channel) throws IOException {
        try {
            System.out.println(new String(message.getBody()));
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
