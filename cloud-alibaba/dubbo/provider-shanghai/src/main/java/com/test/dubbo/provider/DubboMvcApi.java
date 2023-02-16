package com.test.dubbo.provider;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author luyi
 */
@RestController
@RequestMapping("dubboMvcApi")
public class DubboMvcApi {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("10%");
        System.out.println(bigDecimal);
    }
    @RequestMapping(value = "/sayHello", consumes = MediaType.TEXT_HTML_VALUE)
    public String sayHello() {
        return "hello:shanghai";
    }
}
