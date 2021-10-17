package com.demo.cloud.resttemplate.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author luyi
 * openfeign服务消费端
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.demo.cloud.resttemplate.consumer")
public class RestTemplateConsumerStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RestTemplateConsumerStarter.class);
        springApplication.run(args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
