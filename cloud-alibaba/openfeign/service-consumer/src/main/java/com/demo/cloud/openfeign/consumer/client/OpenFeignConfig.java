package com.demo.cloud.openfeign.consumer.client;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author luyi
 */
public class OpenFeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }


}
