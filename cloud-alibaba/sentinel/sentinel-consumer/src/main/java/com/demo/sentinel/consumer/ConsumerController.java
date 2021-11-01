package com.demo.sentinel.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 */
@RestController
public class ConsumerController {

    @GetMapping("/test")
    @SentinelResource(value = "test", fallbackClass = FallBack.class, fallback = "back")
    public String test() {
        return "test";
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }

}
