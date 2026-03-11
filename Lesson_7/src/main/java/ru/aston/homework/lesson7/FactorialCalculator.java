package ru.aston.homework.lesson7;

public class FactorialCalculator {

    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть >= 0");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}