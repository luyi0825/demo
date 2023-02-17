package com.example.spring.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Service;

/**
 * @author luyi
 */
@Service
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor->postProcessBeanDefinitionRegistry");
        BeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setLazyInit(false);
        beanDefinition.setBeanClassName(MyBeanDefinitionRegistryPostProcessorBean.class.getName());
        registry.registerBeanDefinition("MyBeanDefinitionRegistryPostProcessorBean",beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    class MyBeanDefinitionRegistryPostProcessorBean{
        MyBeanDefinitionRegistryPostProcessorBean(){
            System.out.println("MyBeanDefinitionRegistryPostProcessorBean init");
        }
    }
}
