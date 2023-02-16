package com.example.spring.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

/**
 * 自定义BeanFactoryPostProcessor
 *
 * @author luyi
 */
@Service
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerSingleton("myBeanFactoryPostProcessorBean", MyBeanFactoryPostProcessorBean.class);
    }

    class MyBeanFactoryPostProcessorBean {
        MyBeanFactoryPostProcessorBean() {
            System.out.println("MyBeanFactoryPostProcessorBean初始化");
        }

    }
}
