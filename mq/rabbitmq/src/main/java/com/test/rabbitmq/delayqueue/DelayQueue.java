package com.test.rabbitmq.delayqueue;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author luyi
 * 延迟队列
 */
@Component
public class DelayQueue {

    @RabbitListener(queues = DelayQueueConfig.DELAY_DLX_QUEUE)
    public void process(Message message, Channel channel) throws IOException {
        System.out.println(new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }


}
