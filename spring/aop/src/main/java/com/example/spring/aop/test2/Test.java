package com.example.spring.aop.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println(isValid2("([)]"));
    }


    public static boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) {
            return false;
        }
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            Character character = chars[i];
            if (character.equals('{')) {
                characterStack.add('}');
            } else if (character.equals('(')) {
                characterStack.add(')');
            } else if (character.equals('[')) {
                characterStack.add(']');
            } else if (characterStack.isEmpty() || !characterStack.pop().equals(character)) {
                return false;
            }
        }
        return characterStack.isEmpty();


    }


}
