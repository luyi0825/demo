package com.test.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author luyi
 * dubbo服务消费者
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.test.dubbo.consumer.client")
@EnableDiscoveryClient
public class DubboConsumerStarter {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerStarter.class, args);
    }
}
