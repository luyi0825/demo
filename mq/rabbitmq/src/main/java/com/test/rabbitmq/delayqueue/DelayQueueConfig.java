package com.test.rabbitmq.delayqueue;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luyi
 * 延迟队列
 */
@Configuration
public class DelayQueueConfig {

    /**
     * 延迟队列
     */
    public static final String NORMAL_DELAY_QUEUE = "normal_delay_queue";

    public static final String NORMAL_DELAY_EXCHANGE = "normal_delay_exchange";

    //ttl
    private static final int NORMAL_DELAY_EXPIRATION = 10000;

    //设置队列长度限制

    private static final int NORMAL_DELAY_LENGTH = 10;


    public static final String DELAY_DLX_QUEUE = "delay_dlx_queue";

    public static final String DELAY_DLX_EXCHANGE = "delay_dlx_exchange";


    //绑定死信队列
    @Bean
    public Queue normalDelayQueue() {
        return QueueBuilder.durable(NORMAL_DELAY_QUEUE)
                .withArgument("x-dead-letter-exchange", DELAY_DLX_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", "dlx.hehe")
                .withArgument("x-message-ttl", NORMAL_DELAY_EXPIRATION)
                .withArgument("x-max-length", NORMAL_DELAY_LENGTH)
                .build();
    }

    @Bean
    public TopicExchange normalDelayExchange() {
        return new TopicExchange(NORMAL_DELAY_EXCHANGE);
    }

    @Bean
    public Binding normalDelayBinding() {
        return BindingBuilder.bind(normalDelayQueue()).to(normalDelayExchange()).with("test.dlx.#");
    }

    //声明死信队列,和死信交换机
    @Bean
    public Queue testDelayQueue() {
        return new Queue(DELAY_DLX_QUEUE);
    }

    @Bean
    public TopicExchange delayExchange() {
        return new TopicExchange(DELAY_DLX_EXCHANGE);
    }

    @Bean
    public Binding delayBinding() {
        return BindingBuilder.bind(testDelayQueue()).to(delayExchange()).with("dlx.*");
    }


}
