package com.example.spring.aop.test2;

import java.util.HashMap;

public class addBinary {
    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        return Long.toBinaryString((Long.parseLong(a, 2) + Long.parseLong(b, 2)));
    }
}
