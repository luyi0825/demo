package com.example.spring.aop;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Method;

/**
 * @author luyi
 */
@EnableAspectJAutoProxy()
@ComponentScan(basePackages = "com.example.spring.aop")
public class SpringAopStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAopStart.class);
        //context.scan();
        AopService aopService = (AopService) context.getBean("aopService");
        aopService.sayGood();
        aopService.test();

        AopService aopService2 = (AopService) context.getBean("aopService2");
        aopService2.sayGood();
        aopService.test();
    }



}
