package ru.aston.homework.lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

public class IntCalculatorTest {

    private final IntCalculator calculator = new IntCalculator();

    @Test
    public void add() {
        assertEquals(calculator.add(2, 3), 5);
    }

    @Test
    public void subtract() {
        assertEquals(calculator.subtract(2, 3), -1);
    }

    @Test
    public void multiply() {
        assertEquals(calculator.multiply(2, 3), 6);
    }

    @Test
    public void divide() {
        assertEquals(calculator.divide(6, 3), 2);
    }

    @Test
    public void divideByZeroThrowsException() {
        expectThrows(ArithmeticException.class,
                () -> calculator.divide(10, 0));
    }

    // некорректный тест
    @Test
    public void addWrongExpectedValue() {
        // на самом деле 2 + 3 = 5
        assertEquals(calculator.add(2, 3), 10);
    }
}

