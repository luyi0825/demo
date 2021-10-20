package com.demo.cloud.webclient.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 * webclient服务提供方-上海
 */
@SpringBootApplication
public class WebClientShangHaiProviderStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WebClientShangHaiProviderStarter.class);
        springApplication.run(args);
    }
}
