package com.example.spring.facotybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<FactoryBeanEntity> {

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

    @Override
    public FactoryBeanEntity getObject() throws Exception {
        FactoryBeanEntity factoryBeanEntity= new FactoryBeanEntity("MyFactoryBean->getObject");
        return factoryBeanEntity;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
