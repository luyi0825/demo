package com.demo.rocketmq.boot.ack;


import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@RocketMQMessageListener(consumerGroup = "test", topic = "test-spring-boot")
@Component
public class AckConcurencyConsumer implements RocketMQListener<String> {
    AtomicInteger count = new AtomicInteger(0);

    @Override
    public void onMessage(String s) {
        int num = count.incrementAndGet();
        if (num % 2 == 0) {
            throw new RuntimeException();
        }
        System.out.println(s);

    }
//    @Override
//    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
//        System.out.println(list.size());
//        for (MessageExt messageExt : list) {
//            System.out.println(new String(messageExt.getBody()));
//        }
//        return ConsumeConcurrentlyStatus.RECONSUME_LATER;

}
