package com.demo.sentinel.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author luyi
 */
@SpringBootApplication
@EnableFeignClients
public class SentinelConsumerStarter {
    public static void main(String[] args) {
        SpringApplication.run(SentinelConsumerStarter.class, args);
    }
}
