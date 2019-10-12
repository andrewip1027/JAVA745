public class Point3D extends Point {
    private double z;

    public Point3D(double x, double y, double z, Color color) {
        super(x, y, color);
        this.z = z;
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return this.z;
    }

    public void moveTo(double x, double y, double z) {
        super.moveTo(x, y); //dont need set X Y because MoveTo 
        this.z = z;
    }
}