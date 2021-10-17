package com.demo.cloud.resttemplate.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luyi
 * openfeign服务消费端
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RestTemplateProviderStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RestTemplateProviderStarter.class);
        springApplication.run(args);
    }
}
