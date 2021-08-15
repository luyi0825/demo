package com.example.spring.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 * aop service
 */
@Service("aopService")
public interface AopService  {

    public void sayGood();

    public void test();
}
