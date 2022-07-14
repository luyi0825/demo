package com.demo.sql.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 * 数据源启动类
 */
@SpringBootApplication(scanBasePackages = "com.demo.sql.dynamic")
@MapperScan("com.demo.sql.dynamic.mapper")
public class DataSourceStarter {
    public static void main(String[] args) {
        new SpringApplication(DataSourceStarter.class).run(args);
    }
}
