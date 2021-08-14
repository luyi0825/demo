package com.example.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopServiceAspectj {

    /**
     * 切点
     */
    @Pointcut("within(com.example.spring.aop.AopService))")
    public void cacheablePointcut() {
    }

    @Around("cacheablePointcut()")
    public Object cacheable(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("in");
        Object returnValue= jp.proceed(jp.getArgs());
        System.out.println("out");
        return returnValue;
    }


}
