package com.demo.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 */
@SpringBootApplication
@MapperScan(basePackages = "com.demo.mybatis.mapper")
public class MybatisStarter {

    public static void main(String[] args) {
        SpringApplication.run(MybatisStarter.class, args);
    }
}
