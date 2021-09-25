package com.test.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqUtils {

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("luyi");
        factory.setPassword("123456");
        factory.setVirtualHost("test");
        factory.setPort(5672);
        factory.setHost("localhost");
        return factory.newConnection();
    }

}
