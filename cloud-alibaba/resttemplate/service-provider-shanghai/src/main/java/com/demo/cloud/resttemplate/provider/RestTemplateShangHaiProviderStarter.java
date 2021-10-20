package com.demo.cloud.resttemplate.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 * restTemplate服务提供方-上海
 */
@SpringBootApplication
public class RestTemplateShangHaiProviderStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RestTemplateShangHaiProviderStarter.class);
        springApplication.run(args);
    }
}
