package com.test.mybatis.batch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luyi
 * 批量处理
 */
@SpringBootApplication
@MapperScan(basePackages = " com.test.mybatis.batch.mapper")
public class BatchApplication {
    public static void main(String[] args) {
        new SpringApplication(BatchApplication.class).run(args);
    }
}
