package ru.aston.homework.lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest {

    private final TriangleAreaCalculator calculator = new TriangleAreaCalculator();

    @Test
    void areaCorrect() {
        double s = calculator.area(3, 4, 5);
        assertEquals(6.0, s, 1e-6);
    }

    @Test
    void invalidTriangleThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.area(1, 2, 10));
    }

    // некорректный тест
    @Test
    void areaWrongExpectedValue() {
        // на самом деле площадь треугольника 3-4-5 равна 6
        assertEquals(10.0, calculator.area(3, 4, 5), 1e-6);
    }

}
