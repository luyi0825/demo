package com.demo.sentinel.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luyi
 */
@FeignClient(name="sentinel-provider")
public interface ProviderFeign {

    @GetMapping("/sayHello")
    public String sayHello();
}
