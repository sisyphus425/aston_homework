public class Rectangle implements Shape{

    private double length; // длина прямоугольника
    private double width; // ширина прямоугольника
    private String fillColor;
    private String borderColor;

    public Rectangle(double length, double width, String fillColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Расчет периметра (2*(a+b))
    @Override
    public double getPerimeter(){
        return 2 * (length + width);
    }

    // Расчет площади (a*b)
    @Override
    public double getArea(){
        return length * width;
    }

    // Геттер для цвета заливки
    @Override
    public String getFillColor(){
        return fillColor;
    }

    // Геттер для цвета границ
    @Override
    public String getBorderColor(){
        return borderColor;
    }
}
