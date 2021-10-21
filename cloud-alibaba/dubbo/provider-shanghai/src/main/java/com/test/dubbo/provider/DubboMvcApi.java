package com.test.dubbo.provider;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 */
@RestController
@RequestMapping("dubboMvcApi")
public class DubboMvcApi {

    @RequestMapping(value = "/sayHello", consumes = MediaType.TEXT_HTML_VALUE)
    public String sayHello() {
        return "hello:shanghai";
    }
}
