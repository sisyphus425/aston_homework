public class Triangle implements Shape{

    // стороны треугольника
    private double a;
    private double b;
    private double c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Расчет периметра (a+b+c)
    @Override
    public double getPerimeter(){
        return a + b + c;
    }

    // Расчет площади (по формуле Герона)
    @Override
    public double getArea(){
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
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