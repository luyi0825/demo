//package com.example.spring.aop.test2;
//
///**
// * 罗马数字转数字
// * https://leetcode.cn/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150
// */
//public class RomanToInt {
//
//    public int romanToInt(String s) {
//        String intToChar = "IVXLCDM";
//        int value = 0;
//
//        char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
//        for (int i = 0; i < chars.length; i++) {
//            char c = chars[i];
//            int index = intToChar.indexOf(c);
//            if (index == 0) {
//                value += 1;
//            } else if (index == 1) {
//                if (i < chars.length - 1) {
//                    char next = chars[i + 1];
//                    int nextIndex = intToChar.indexOf(next);
//                    if (nextIndex == 0) {
//                    }
//                }
//            }
//        }
//
//    }
//}
