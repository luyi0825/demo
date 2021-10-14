package com.test.dubbo.consumer;

import com.test.dubbo.api.DubboDemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @DubboReference
    private DubboDemoService demoService;

    @RequestMapping("/test")
    public String test(@RequestParam(name="name") String name){
       return demoService.sayName(name);
    }
}
