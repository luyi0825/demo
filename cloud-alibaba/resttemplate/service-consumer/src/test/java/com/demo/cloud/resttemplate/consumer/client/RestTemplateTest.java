package com.demo.cloud.resttemplate.consumer.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestTemplateTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void sayHello() {
        //http://localhost:8080/
        String url = "http://resttemplate-provider/restTemplateApi/sayHello";
        for (int i = 0; i < 10; i++) {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            System.out.println(responseEntity.getBody());
        }

    }


}