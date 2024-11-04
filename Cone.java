// this is the cone child of the shape class
public class Cone extends Shape {//this needs 2 variables height and radius
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {//this is the polymorphed method in the cone class for area
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public double volume() {//this is the polymorphed method in the cone class for volume.
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {//these are the instructions to return the values to the ShapeArray class
        return "Cone:\n" +
                "Surface Area: " + surface_area() + "\n" +
                "Volume: " + volume() + "\n";
    }
}