package com.demo.cloud.openfeign.consumer;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


/**
 * @author luyi
 * openfeign服务消费端
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.demo.cloud.openfeign.consumer")
public class OpenFeignConsumerStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OpenFeignConsumerStarter.class);
        springApplication.run(args);
    }

    /**
     * 全局配置
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
