public class Shape {
    double length;
    double width;
    double radius;


    public double calculateAreaRectangle() {
        return length * width;
    }

    public double calculatePerimeterRectangle() {
        return 2 * (length + width);
    }

    public double calculateAreaCircle() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeterCircle() {
        return 2 * (Math.PI * radius);
    }
}
