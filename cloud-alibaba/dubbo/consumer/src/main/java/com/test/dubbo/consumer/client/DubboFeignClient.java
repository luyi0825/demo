package com.test.dubbo.consumer.client;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luyi
 * feignClient转dubbo
 */
@DubboTransported
@FeignClient(name = "dubbo-provider", path = "/dubboMvcApi")
public interface DubboFeignClient {

    @RequestMapping(value = "/sayHello", consumes = MediaType.TEXT_HTML_VALUE)
    String sayHello();

}
