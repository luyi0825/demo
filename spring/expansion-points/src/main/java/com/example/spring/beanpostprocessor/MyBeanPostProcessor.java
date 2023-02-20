package com.example.spring.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @author luyi
 */
@Service
public class MyBeanPostProcessor implements BeanPostProcessor {


    public MyBeanPostProcessor(){
        System.out.println("MyBeanPostProcessor");
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor->postProcessBeforeInitialization");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor->postProcessAfterInitialization");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
