package com.demo.shardingjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * redis测试启动类
 *
 * @author luyi
 */
@SpringBootApplication(scanBasePackages="com.demo.shardingjdbc.dao")
//@MapperScan( basePackages= {"com.demo.shardingjdbc.dao"})
public class ShardingJdbcStater {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcStater.class, args);
    }
}
