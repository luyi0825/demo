package com.test.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luyi
 * dubbo服务提供者
 */
@SpringBootApplication
//@EnableDubbo(scanBasePackages = "com.test.dubbo.provider")
@EnableDiscoveryClient
public class DubboProviderStarter {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderStarter.class, args);
    }
}
