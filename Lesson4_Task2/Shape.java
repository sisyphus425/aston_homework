public interface Shape {
    String getFillColor(); // цвет заливки фигуры
    String getBorderColor(); // цвет границ фигуры

    double getPerimeter(); // периметр фигуры
    double getArea(); // площадь фигуры

    // общая логика вывода информации о фигуре (default-метод для вывода)
    default void printInfo(){
        System.out.println("Фигура: " + getClass().getSimpleName());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
        System.out.println("---------------");
    }
}
