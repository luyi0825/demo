package com.demo.shardingproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 */
@SpringBootApplication(scanBasePackages = "com.demo.shardingproxy.dao")
public class ShardingProxyStater {
    public static void main(String[] args) {
        SpringApplication.run(ShardingProxyStater.class, args);
    }
}
