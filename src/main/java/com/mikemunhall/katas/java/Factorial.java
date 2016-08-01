package com.mikemunhall.katas.java;

public class Factorial {

    public static int getResult(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        } else if (x == 0) {
            return 1;
        } else {
            return x * getResult(x - 1);
        }
    }
}
