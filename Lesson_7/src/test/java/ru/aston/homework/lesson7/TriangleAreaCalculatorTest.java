package ru.aston.homework.lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

public class TriangleAreaCalculatorTest {

    private final TriangleAreaCalculator calculator = new TriangleAreaCalculator();

    @Test
    public void areaCorrect() {
        double s = calculator.area(3, 4, 5);
        assertEquals(s, 6.0, 1e-6);
    }

    @Test
    public void invalidTriangleThrowsException() {
        expectThrows(IllegalArgumentException.class,
                () -> calculator.area(1, 2, 10));
    }

    // некорректный тест
    @Test
    public void areaWrongExpectedValue() {
        // на самом деле площадь треугольника 3-4-5 равна 6
        double s = calculator.area(3, 4, 5);
        assertEquals(s, 10.0, 1e-6);
    }
}
