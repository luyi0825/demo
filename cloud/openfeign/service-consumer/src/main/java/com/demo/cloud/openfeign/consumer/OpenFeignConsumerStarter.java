package com.demo.cloud.openfeign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author luyi
 * openfeign服务消费端
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.demo.cloud.openfeign.consumer")
public class OpenFeignConsumerStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OpenFeignConsumerStarter.class);
        springApplication.run(args);
    }
}
