package com.example.spring.transaction;

import org.springframework.stereotype.Service;

@Service
public class A {

    public A(B b) {
        System.out.println("1");
    }

    public A() {
        System.out.println("0");
    }

    public A(B b, C c) {
        System.out.println("2");
    }
}
