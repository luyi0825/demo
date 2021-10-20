package com.demo.cloud.resttemplate.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 * restTemplate服务提供方-wuhan
 */
@SpringBootApplication
public class RestTemplateWuHanProviderStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RestTemplateWuHanProviderStarter.class);
        springApplication.run(args);
    }
}
