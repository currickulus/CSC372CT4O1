// this is the sphere child of the parent class
public class Sphere extends Shape {
    private double radius;//this tells what its gonna get cause thats all it needs

    public Sphere(double radius) {
        this.radius = radius;//this is the this
    }

    @Override
    public double surface_area() {//this is the polymorphed method in the sphere class for area
        //did you know that if the radius is 5 and the height and radius of a cylinder is 5
        //the surface area is the same for both? I thought the math was broken when I ran the program.
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double volume() {//this is the polymorphed method in the sphere class for volume.

        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override//these are the instructions to return the values to the ShapeArrayss class
    public String toString() {
        return "Sphere:\n" +
                "Surface Area: " + surface_area() + "\n" +
                "Volume: " + volume() + "\n";
    }
}