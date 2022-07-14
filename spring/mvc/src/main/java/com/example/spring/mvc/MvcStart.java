package com.example.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author luyi
 */
@SpringBootApplication
@RestController
public class MvcStart {
    public static void main(String[] args) {
        SpringApplication.run(MvcStart.class, args);
    }

    @GetMapping("/test")
    public String test(HttpSession session) {
        return UUID.randomUUID().toString();
    }

}
