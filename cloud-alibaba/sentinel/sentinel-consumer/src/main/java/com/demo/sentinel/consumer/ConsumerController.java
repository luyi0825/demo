package com.demo.sentinel.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 */
@RestController
public class ConsumerController {

    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("/test")
    @SentinelResource(value = "test", fallbackClass = FallBack.class, fallback = "back")
    public String test() {
        return "test";
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        return providerFeign.sayHello();
    }

}
