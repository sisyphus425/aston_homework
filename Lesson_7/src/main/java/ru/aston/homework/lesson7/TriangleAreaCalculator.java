package ru.aston.homework.lesson7;

public class TriangleAreaCalculator {

    public double area(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны должны быть > 0");
        }
        // по формуле Герона
        double p = (a + b + c) / 2.0;
        double s2 = p * (p - a) * (p - b) * (p - c);
        if (s2 <= 0) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        return Math.sqrt(s2);
    }
}
