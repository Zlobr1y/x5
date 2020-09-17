package Task1;

public class Circle implements Shape {
    double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return 3.1415*(radius*radius);
    }
}
