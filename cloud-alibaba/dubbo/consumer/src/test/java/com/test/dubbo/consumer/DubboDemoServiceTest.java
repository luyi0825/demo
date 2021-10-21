package com.test.dubbo.consumer;

import com.test.dubbo.api.DubboDemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DubboDemoServiceTest {
    @Autowired
    private DubboDemoService demoService;

    @Test
    public void test() {
        for (int i = 0; i < 3; i++) {
            System.out.println(demoService.sayName("test"));
        }
    }
}
