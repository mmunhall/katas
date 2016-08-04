package com.mikemunhall.katas.java;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void getResultShouldReturnFizzBuzz() {
        assertEquals(FizzBuzz.getResult(0), "fizzbuzz");
        assertEquals(FizzBuzz.getResult(1), "1");
        assertEquals(FizzBuzz.getResult(2), "2");
        assertEquals(FizzBuzz.getResult(3), "fizz");
        assertEquals(FizzBuzz.getResult(4), "4");
        assertEquals(FizzBuzz.getResult(5), "buzz");
        assertEquals(FizzBuzz.getResult(6), "fizz");
        assertEquals(FizzBuzz.getResult(7), "7");
        assertEquals(FizzBuzz.getResult(8), "8");
        assertEquals(FizzBuzz.getResult(9), "fizz");
        assertEquals(FizzBuzz.getResult(10), "buzz");
        assertEquals(FizzBuzz.getResult(15), "fizzbuzz");
        assertEquals(FizzBuzz.getResult(16), "16");
        assertEquals(FizzBuzz.getResult(30), "fizzbuzz");
    }
}
