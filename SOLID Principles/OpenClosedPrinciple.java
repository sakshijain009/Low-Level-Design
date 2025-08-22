// Shape interface
interface Shape {
    double area();
}

// Rectangle implements Shape
class Rectangle implements Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Circle implements Shape
class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// New shape (extension, no modification)
class Triangle implements Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// Area calculator follows OCP
class AreaCalculator {
    public double calculate(Shape shape) {
        return shape.area();
    }
}

// Example usage
public class OCPExample {
    public static void main(String[] args) {
        Shape rect = new Rectangle(10, 5);
        Shape circle = new Circle(7);
        Shape triangle = new Triangle(6, 4);

        AreaCalculator calculator = new AreaCalculator();

        System.out.println("Rectangle area: " + calculator.calculate(rect));
        System.out.println("Circle area: " + calculator.calculate(circle));
        System.out.println("Triangle area: " + calculator.calculate(triangle));
    }
}
