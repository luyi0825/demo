package com.test.rabbitmq.publishsubscribe;

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
 * 发布订阅
 */
@Component
public class PublishSubscribe2 {

    @RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = PublishSubscribeConstants.EXCHANGE, type = ExchangeTypes.FANOUT),
            value = @Queue(name = "publish_subscribe_test1")))
    public void process1(Message message, Channel channel) throws IOException {
        String str = new String(message.getBody());
        System.out.println(str+"test1");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = PublishSubscribeConstants.EXCHANGE, type = ExchangeTypes.FANOUT),
            value = @Queue(name = "publish_subscribe_test2")), concurrency = "2")
    public void process2(Message message, Channel channel) throws IOException {
        String str = new String(message.getBody());
        System.out.println(str+"test2");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
