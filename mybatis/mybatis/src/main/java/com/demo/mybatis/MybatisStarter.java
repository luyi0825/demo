package com.demo.mybatis;

import com.demo.mybatis.son.SonModuleConfigure;
import com.demo.mybatis.son.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author luyi
 */
@SpringBootApplication
public class MybatisStarter {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(new Class[]{MybatisStarter.class, SonModuleConfigure.class}, args);
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.selectById(6));
    }
}
