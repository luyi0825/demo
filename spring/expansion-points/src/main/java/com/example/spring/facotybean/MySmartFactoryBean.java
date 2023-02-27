package com.example.spring.facotybean;

import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySmartFactoryBean implements SmartFactoryBean {


//    @Autowired
//    private MySmartFactoryBean mySmartFactoryBean;
    @Override
    public Object getObject() throws Exception {
        FactoryBeanEntity factoryBeanEntity= new FactoryBeanEntity("MySmartFactoryBean->getObject");
        return factoryBeanEntity;
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanEntity.class;
    }

    @Override
    public boolean isPrototype() {
        return SmartFactoryBean.super.isPrototype();
    }

    @Override
    public boolean isEagerInit() {
        return true;
    }
}
