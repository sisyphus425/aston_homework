public class Circle implements Shape{

    private double radius; // радиус круга
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Расчет периметра (2пr)
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

    // Расчет площади (пr^2)
    @Override
    public double getArea(){
        return Math.PI * radius * radius;
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
