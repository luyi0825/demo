package com.example.spring.aop;

import org.springframework.stereotype.Service;

@Service("aopService")
public class AopServiceImpl implements AopService {


    @Override
    public void sayGood() {
        System.out.println("good");
    }

    @Override
    public void test() {
        System.out.println("test");
    }
}
