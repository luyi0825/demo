package com.example.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * spring拓展点启动类
 *
 * @author luyi
 */
@SpringBootApplication
public class SpringExpansionPointsStater {
    public static void main(String[] args) {
        new SpringApplication(SpringExpansionPointsStater.class).run(args);
    }


}
