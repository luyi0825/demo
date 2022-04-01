package com.demo.mybatis.son;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author luyi
 */
@Configuration
@MapperScan(basePackages = "com.demo.mybatis.son.mapper")
public class SonModuleConfigure {

}
