package com.demo.cloud.openfeign.provider;

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
public class OpenFeignProviderStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OpenFeignProviderStarter.class);
        springApplication.run(args);
    }
}
