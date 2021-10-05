package com.demo.rocketmq.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author luyi
 */
@SpringBootApplication
public class RocketStreamStarter {
    public static void main(String[] args) {
        SpringApplication.run(RocketStreamStarter.class, args);
    }

    @Bean
    public Supplier<String> source1() {
        return () -> "Hello from Supplier";
    }

    @Bean
    public Consumer<String> sink1() {
        return value -> {
            System.out.println("566:" + value);
        };

    }

}
