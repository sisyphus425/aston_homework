package ru.aston.homework.lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntCalculatorTest {

    private final IntCalculator calculator = new IntCalculator();

    @Test
    void add() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void subtract() {
        assertEquals(-1, calculator.subtract(2, 3));
    }

    @Test
    void multiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    void divide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void divideByZeroThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(10, 0));
    }

    // некорректный тест
    @Test
    void addWrongExpectedValue() {
        // на самом деле 2 + 3 = 5
        assertEquals(10, calculator.add(2, 3));
    }

}
