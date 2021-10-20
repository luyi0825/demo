package com.demo.cloud.webclient.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 * RestTemplate的接口
 */
@RestController
@RequestMapping("/webClientApi")
public class WebClientApi {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello:shanghai";
    }

}
