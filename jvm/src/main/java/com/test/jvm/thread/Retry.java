package com.test.jvm.thread;

public class Retry {

    public static void main(String[] args) {

        retry:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(j + ", ");
                if (j == 3) {
                    break retry;
                }
            }
        }
        System.out.print(" >>> OK");
    }

}
