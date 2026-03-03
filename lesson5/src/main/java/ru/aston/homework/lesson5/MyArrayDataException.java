package ru.aston.homework.lesson5;

// Исключение для ошибки данных в массиве
public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

