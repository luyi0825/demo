package com.demo.cloud.resttemplate.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author luyi
 * openfeign服务消费端
 */
@SpringBootApplication
public class RestTemplateConsumerStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RestTemplateConsumerStarter.class);
        springApplication.run(args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
