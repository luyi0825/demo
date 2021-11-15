package com.demo.sentinel.nacosdatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 * nacos-sentinel服务启动类-利用nacos做持久化
 */
@SpringBootApplication
public class NacosSentinelStarter {
    public static void main(String[] args) {
        SpringApplication.run(NacosSentinelStarter.class, args);
    }


}
