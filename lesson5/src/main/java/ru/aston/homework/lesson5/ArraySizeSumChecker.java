package ru.aston.homework.lesson5;

public class ArraySizeSumChecker {

    public static int checksumArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        // 1. Проверка размера массива 4x4.
        if (array.length != 4) {
            throw new MyArraySizeException(
                    "Некорректное количество строк: ожидалось 4, получено " + array.length
            );
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        "Некорректное количество столбцов в строке " + i +
                                ": ожидалось 4, получено " + array[i].length
                );
            }
        }

        // 2. Парсинг и суммирование элементов.
        int sum = 0;
        // Массив должен быть 4x4
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String value = array[i][j];

                try {
                    int number = Integer.parseInt(value); // попытка преобразовать строку в int
                    sum += number;
                } catch (NumberFormatException e) {
                    // Если преобразование не удалось — выброс исключения
                    throw new MyArrayDataException(
                            "Неверные данные в ячейке [" + i + "][" + j + "]: '" + value + "'"
                    );
                }
            }
        }

        return sum;
    }

    // 3. main(), который вызывает checksumArray и обрабатывает исключения
    public static void main(String[] args) {

        // Корректный массив 4x4
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Некорректный массив 3x4
        String[][] wrongArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        // Массив 4x4 с ошибкой в данных
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "L"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            // Пример успешного вызова
            int sum1 = checksumArray(correctArray);
            System.out.println("Сумма элементов массива: " + sum1);

            // Пример вызова исключения с неверном размером массива
            //int sum2 = checksumArray(wrongArray);
            //System.out.println("Сумма элементов массива: " + sum2);

            // Пример вызова исключения с ошибкой в данных
            int sum3 = checksumArray(wrongDataArray);
            System.out.println("Сумма элементов массива: " + sum3);

        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage()); // обработка ошибки размера массива
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных в массиве: " + e.getMessage()); // обработка ошибки данных в массиве
        }

        // 4. Генерация и поимка ArrayIndexOutOfBoundsException.
        try {
            int[] arr = {1, 2, 3};
            // Индексы допустимы: 0, 1, 2. Для исключения ужно намерено выйти за границу - 3.
            System.out.println("Элемент с индексом 3: " + arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}

