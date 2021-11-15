package com.demo.sentinel.nacosdatasource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 * nacos-sentinel的控制层
 */
@RestController
public class NacosSentinelController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }

}
