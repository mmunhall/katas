package com.mikemunhall.katas.java;


public class FizzBuzz {

    public static String getResult(Integer x) {
        if (x % 3 == 0 && x % 5 == 0) {
            return "fizzbuzz";
        } else if (x % 3 == 0) {
            return "fizz";
        } else if (x % 5 == 0) {
            return "buzz";
        } else {
            return x.toString();
        }
    }
}
