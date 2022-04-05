package com.example.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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
    }

}
