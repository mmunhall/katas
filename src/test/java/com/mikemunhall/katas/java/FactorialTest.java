package com.mikemunhall.katas.java;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void factorialShouldReturnNBang() {
        assertEquals(Factorial.getResult(0), 1);
        assertEquals(Factorial.getResult(1), 1);
        assertEquals(Factorial.getResult(2), 2);
        assertEquals(Factorial.getResult(3), 6);
        assertEquals(Factorial.getResult(4), 24);
        assertEquals(Factorial.getResult(5), 120);
        assertEquals(Factorial.getResult(6), 720);
        assertEquals(Factorial.getResult(7), 5040);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void factorialShouldThrowIAEForNegativeNumbersss() {
        Factorial.getResult(-5);
    }

}
