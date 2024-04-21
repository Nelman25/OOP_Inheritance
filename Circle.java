public class Circle extends Shape {

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double CalculateArea() {
        return Math.PI*Math.pow(radius, 2);
    }
    @Override
    public double CalculatePerimeter() {
        return 2*Math.PI*radius;
    }
}