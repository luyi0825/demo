package com.demo.sentinel.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 */
@RestController
public class SentinelProviderController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }
}
