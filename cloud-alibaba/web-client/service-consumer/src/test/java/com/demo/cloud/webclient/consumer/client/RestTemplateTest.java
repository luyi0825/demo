package com.demo.cloud.webclient.consumer.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootTest
class RestTemplateTest {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Test
    public void sayHello() {


        //http://localhost:8080/
        String url = "http://webclient-provider/webClientApi/sayHello";
        for (int i = 0; i < 10; i++) {
            Mono<String> mono = webClientBuilder.build().get().uri(url).retrieve().bodyToMono(String.class);

            System.out.println(mono.block());
        }

    }


}