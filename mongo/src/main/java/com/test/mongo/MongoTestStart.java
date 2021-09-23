package com.test.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author luyi
 */
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.test.mongo")
public class MongoTestStart {
    public static void main(String[] args) {
        SpringApplication.run(MongoTestStart.class, args);
    }
}
