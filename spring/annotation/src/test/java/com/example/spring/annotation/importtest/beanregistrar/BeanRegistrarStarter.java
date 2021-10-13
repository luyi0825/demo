package com.example.spring.annotation.importtest.beanregistrar;

import com.example.spring.annotation.importtest.MyImportBeanDefinitionRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MyImportBeanDefinitionRegistrar.class)
public class BeanRegistrarStarter {
    public static void main(String[] args) {
        SpringApplication.run(BeanRegistrarStarter.class, args);
    }
}
