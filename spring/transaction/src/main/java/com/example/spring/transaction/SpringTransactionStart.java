package com.example.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author luyi
 */
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example.spring.transaction")
public class SpringTransactionStart {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringTransactionStart.class);
        TransactionService aopService = (TransactionService) context.getBean("transactionService");
        //aopService.sayGood();
        aopService.addOrder(1);
    }



}
