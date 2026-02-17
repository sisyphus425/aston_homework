public class Lesson_2 {
    public static void main(String[] args) {
        printThreeWords(); // пункт 1
        System.out.println("------------------");
        checkSumSign(); // пункт 2
        System.out.println("------------------");
        printColor(); // пункт 3
        System.out.println("------------------");
        compareNumbers(); // пункт 4
        System.out.println("------------------");

        boolean flag = checkSum(8, 7); // пункт 5
        System.out.println("Результат для пункта 5: " + flag);
        System.out.println("------------------");

        checkSign(5);// пункт 6
        System.out.println("------------------");

        flag = checkSignBool(8); // пункт 7
        System.out.println("Результат для пункта 7: " + flag);
        System.out.println("------------------");

        printStr("All work and no play makes Jack a dull boy",8); // Пункт 8
        System.out.println("------------------");

        flag = checkYear(32); // пункт 9
        System.out.println("Результат для пункта 9: " + flag);
        System.out.println("------------------");

        createArray();// пункт 10
        System.out.println();
        System.out.println("------------------");

        fillArray();// пункт 11
        System.out.println();
        System.out.println("------------------");

        changeArray();// пункт 12
        System.out.println();
        System.out.println("------------------");

        doubleArray();// пункт 13
        System.out.println("------------------");

        System.out.println("Полученный массив (пункт 14):");
        int[] arr = returnArray(10, 4);// пункт 14
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("------------------");






    }

    // 1. Создайте метод printThreeWords()
    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2. Создайте метод checkSumSign()
    public static void checkSumSign(){
        int a = 3;   // объяви и инициализируй ЗДЕСЬ
        int b = 5;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3. Создайте метод printColor()
    public static void printColor(){
        int value = 4;
        if (value <= 0){
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100){
            System.out.println("Желтый");
        }
        if (value > 100){
            System.out.println("Зеленый");
        }
    }

    // 4. Создайте метод compareNumbers()
    public static void compareNumbers(){
        int a = 4;
        int b = 6;
        if (a >= b){
            System.out.println("a >= b");
        }
        else{
            System.out.println("a < b");
        }
    }

    // 5. Напишите метод, принимающий на вход два целых числа...
    public static boolean checkSum(int a, int b){
        int sum = a + b;
        if (sum >= 10 && sum <= 20){
            return true;
        }
        else{
            return false;
        }
    }

    // 6. Напишите метод, которому в качестве параметра передается целое число...
    public static void checkSign(int a){
        if (a >= 0){
            System.out.println("Число положительное");
        }
        else{
            System.out.println("Число отрицательное");
        }
    }

    // 7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true...
    public static boolean checkSignBool(int a){
        if (a >= 0){
            return false;
        }
        else{
            return true;
        }
    }

    //8. Напишите метод, которому в качестве аргументов передается строка и число...
    public static void printStr(String str, int amount){
        for(int i = 0; i < amount; i++){
            System.out.println(str);
        }
    }

    // 9. Напишите метод, который определяет, является ли год високосный...
    public static boolean checkYear(int year){
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        }
        else
        {
            return false;
        }
    }

    // 10. Задать целочисленный массив, состоящий из элементов 0 и 1...
    public static void createArray(){
        int[] arr = {0, 1, 1, 0, 0, 1, 0};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){ arr[i] = 1; }
            else{ arr[i] = 0; }
        }
        System.out.println("Измененный массив (пункт 10):");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    // 11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
    public static void fillArray(){
        int[] arr = new int[100];
        int add = 1;
        for (int i = 0; i < arr.length; i++){
            arr[i] = add++;
        }
        System.out.println("Массив от 1 до 100 (пункт 11):");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    // 12. Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void changeArray(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6){ arr[i] *= 2; }
        }
        System.out.println("Измененный массив (пункт 12):");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    // 13. Создать квадратный двумерный целочисленный массив...
    public static void doubleArray(){
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < 5; i++){
            arr[i][i] = 1;
        }
        for (int i = 0; i < 5; i++) {
            arr[i][4 - i] = 1;
        }
        System.out.println("Диагональ единиц (пункт 13):");
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    // 14. Написать метод, принимающий на вход два аргумента: len и initialValue...
    public static int[] returnArray(int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++){
            arr[i] = initialValue;
        }
        return arr;

    }


}
