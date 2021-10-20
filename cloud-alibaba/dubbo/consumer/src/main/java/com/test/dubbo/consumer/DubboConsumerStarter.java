package com.test.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luyi
 * dubbo服务消费者
 */
@SpringBootApplication
//@EnableDubbo(scanBasePackages = "com.test.dubbo.consumer")
@EnableDiscoveryClient
public class DubboConsumerStarter {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerStarter.class, args);
    }
}
