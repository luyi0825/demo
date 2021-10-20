package com.demo.cloud.openfeign.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author luyi
 * openfeign服务消费端
 */
@SpringBootApplication
public class OpenFeignWuHanProviderStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(OpenFeignWuHanProviderStarter.class);
        springApplication.run(args);
    }
}
