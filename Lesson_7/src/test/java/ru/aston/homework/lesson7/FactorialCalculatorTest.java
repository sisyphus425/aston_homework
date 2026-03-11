package ru.aston.homework.lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    void factorial0() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void factorial3() {
        assertEquals(6, calculator.factorial(3));
    }

    @Test
    void factorial5() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void factorialNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.factorial(-1));
    }

    // некорректный тест
    @Test
    void factorialWrongExpectedValue() {
        // на самом деле 5! = 120
        assertEquals(100, calculator.factorial(5));
    }

}

