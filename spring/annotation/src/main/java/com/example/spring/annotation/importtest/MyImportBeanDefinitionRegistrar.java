package com.example.spring.annotation.importtest;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author luyi
 * 自定义的ImportBeanDefinitionRegistrar
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName(ImportConfiguration.class.getName());
        beanDefinition.setAutowireCandidate(true);
        beanDefinition.setInitMethodName("init");
        registry.registerBeanDefinition("importConfiguration_test", beanDefinition);
    }
}
