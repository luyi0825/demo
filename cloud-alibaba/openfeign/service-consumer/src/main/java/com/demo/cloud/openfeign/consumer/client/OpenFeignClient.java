package com.demo.cloud.openfeign.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luyi
 */
@FeignClient(name = "openfeign-provider")
public interface OpenFeignClient {

    @GetMapping("/openFeignApi/sayHello")
    String sayHello();

}
