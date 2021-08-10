package com.example.mybaitsfluent.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.mybaitsfluent.code.mapper"})
public class FluentStart {
    public static void main(String[] args){
        SpringApplication.run(FluentStart.class,args);
    }
}
