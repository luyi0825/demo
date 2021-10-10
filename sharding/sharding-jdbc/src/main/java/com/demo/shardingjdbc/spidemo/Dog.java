package com.demo.shardingjdbc.spidemo;

/**
 * @author luyi
 */
public class Dog implements Animal {
    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }
}
