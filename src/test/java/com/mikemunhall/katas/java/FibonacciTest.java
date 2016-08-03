package com.mikemunhall.katas.java;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void fibonacciShouldReturnFibonacciUpToMax() {
        List<Integer> compareList = new ArrayList<>();

        assertEquals(Fibonacci.getResult(0), compareList);
        compareList.add(1);
        assertEquals(Fibonacci.getResult(1), compareList);
        compareList.add(1);
        assertEquals(Fibonacci.getResult(2), compareList);
        compareList.add(2);
        assertEquals(Fibonacci.getResult(3), compareList);
        compareList.add(3);
        assertEquals(Fibonacci.getResult(4), compareList);
        compareList.add(5);
        assertEquals(Fibonacci.getResult(5), compareList);
        compareList.add(8);
        assertEquals(Fibonacci.getResult(6), compareList);
        compareList.add(13);
        assertEquals(Fibonacci.getResult(7), compareList);
        compareList.add(21);
        assertEquals(Fibonacci.getResult(8), compareList);
        compareList.add(34);
        assertEquals(Fibonacci.getResult(9), compareList);
        compareList.add(55);
        assertEquals(Fibonacci.getResult(10), compareList);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void fibonacciShouldThrowIAEForNegativeNumbers() {
        Factorial.getResult(-5);
    }
}
