package com.demo.rocketmq.boot.simple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AsyncProducerTest {

    private AsyncProducer asyncProducer;

    @Test
    public void send() {
        asyncProducer.send();
    }

    @Autowired
    public void setAsyncProducer(AsyncProducer asyncProducer) {
        this.asyncProducer = asyncProducer;
    }
}