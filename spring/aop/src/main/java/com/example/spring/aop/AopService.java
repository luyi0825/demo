package com.example.spring.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 * aop service
 */
@Service("aopService")
public class AopService {

    public void sayGood() {
        System.out.println("good");
    }

    public void test() {
        sayGood();
    }
}
