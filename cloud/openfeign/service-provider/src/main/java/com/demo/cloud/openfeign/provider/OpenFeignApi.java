package com.demo.cloud.openfeign.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 * openfeignClient的接口
 */
@RestController
@RequestMapping("/openFeignApi")
public class OpenFeignApi {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }

}
