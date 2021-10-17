package com.demo.cloud.resttemplate.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 * openfeignClient的接口
 */
@RestController
@RequestMapping("/restTemplateApi")
public class RestTemplateApi {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }

}
