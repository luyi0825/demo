package com.demo.shardingjdbc.spidemo;

import java.util.ServiceLoader;

/**
 * SPI测试
 *
 * @author luyi
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        animals.forEach(Animal::shout);
    }
}
