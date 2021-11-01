package com.demo.nacosconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author luyi
 * 刷新测试的controller
 */
@RestController
@RefreshScope
public class RefreshController {

    @Value("${name:}")
    private String name;

    @RequestMapping("/test")
    public String test() {
        return name;
    }
}
