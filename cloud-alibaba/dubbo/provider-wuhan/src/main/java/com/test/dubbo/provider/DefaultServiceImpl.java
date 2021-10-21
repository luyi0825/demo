package com.test.dubbo.provider;

import com.test.dubbo.api.DubboDemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author luyi
 */
@DubboService
public class DefaultServiceImpl implements DubboDemoService {
    @Override
    public String sayName(String name) {
        return "wuhan:" + name;
    }
}
