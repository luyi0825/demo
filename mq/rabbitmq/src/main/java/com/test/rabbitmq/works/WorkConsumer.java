package com.test.rabbitmq.works;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author luyi
 * 工作队列消费者
 */
@Component
public class WorkConsumer {

    public static final String WORK_QUEUE = "works_queue";

    @RabbitListener(queuesToDeclare = {@Queue(name = WORK_QUEUE)}, concurrency = "1")
    public void process(Message message, Channel channel) throws IOException {
        System.out.println(new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
