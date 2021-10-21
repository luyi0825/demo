package com.test.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luyi
 * dubbo服务提供者
 */
@SpringBootApplication
public class DubboShangHaiProviderStarter {
    public static void main(String[] args) {
        SpringApplication.run(DubboShangHaiProviderStarter.class, args);
    }
}
