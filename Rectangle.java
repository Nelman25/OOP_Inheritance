public class Rectangle extends Shape {

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double CalculateArea() {
        return length * width;
    }

    @Override
    public double CalculatePerimeter() {
        return (2 * length) + (2 * width);
    }
}
