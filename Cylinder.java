// this is the cylinder child of the shape class
public class Cylinder extends Shape {//this needs 2 variables height and radius
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {//this is the polymorphed method in the cylinder class for area
        //did you know that if the radius is 5 and the height and radius of a cylinder is 5
        //the surface area is the same for both? I thought the math was broken when I ran the program.
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    public double volume() {//this is the polymorphed method in the cylinder class for volume.
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {//these are the instructions to return the values to the ShapeArray class
        return "Cylinder:\n" +
                "Surface Area: " + surface_area() + "\n" +
                "Volume: " + volume() + "\n";
    }
}