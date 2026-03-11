package ru.aston.homework.lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

public class FactorialCalculatorTest {

    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void factorial0() {
        assertEquals(calculator.factorial(0), 1L);
    }

    @Test
    public void factorial3() {
        assertEquals(calculator.factorial(3), 6L);
    }

    @Test
    public void factorial5() {
        assertEquals(calculator.factorial(5), 120L);
    }

    @Test
    public void factorialNegativeThrowsException() {
        expectThrows(IllegalArgumentException.class,
                () -> calculator.factorial(-1));
    }

    // некорректный тест
    @Test
    public void factorialWrongExpectedValue() {
        // на самом деле 5! = 120
        assertEquals(calculator.factorial(5), 100L);
    }
}


