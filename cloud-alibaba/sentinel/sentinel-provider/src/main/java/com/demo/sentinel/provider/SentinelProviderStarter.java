package com.demo.sentinel.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 * sentinel服务提供者启动类
 */
@SpringBootApplication
public class SentinelProviderStarter {
    public static void main(String[] args) {
        SpringApplication.run(SentinelProviderStarter.class, args);
    }
}
