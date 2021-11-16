package com.demo.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 * oauth服务启动类
 * https://github.com/spring-projects/spring-security/wiki/OAuth-2.0-Migration-Guide
 */
@SpringBootApplication

public class OauthApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplicationStarter.class, args);
    }
}
