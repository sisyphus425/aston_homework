public class ShapesApp {
    public static void main(String[] args) {

        Shape circle = new Circle(4, "green", "blue");
        Shape rectangle = new Rectangle (7.5, 6.5, "white", "yellow");
        Shape triangle = new Triangle(3.5, 4, 5, "black","pink");

        // создание массива из объектов (фигур)
        Shape[] shapes = {circle, rectangle, triangle};

        // обход массива с вызовом printInfo() для каждого
        for(Shape shape : shapes){
            shape.printInfo();
        }

    }
}
