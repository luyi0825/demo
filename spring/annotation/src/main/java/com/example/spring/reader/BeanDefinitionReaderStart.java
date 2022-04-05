package com.example.spring.reader;

import com.example.spring.SpringConfigStart;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class BeanDefinitionReaderStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigStart.class);


      //  context.register(BeanDefinitionService.class);

//        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
//        annotatedBeanDefinitionReader.register(BeanDefinitionService.class);

        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(context);
        classPathBeanDefinitionScanner.scan("com.example.spring.reader");
        //Xml
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
//        xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");

        System.out.println(context.getBean(BeanDefinitionService.class));
    }
}
