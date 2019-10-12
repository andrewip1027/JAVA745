public class ColorCMYK extends Color {
    private double c;
    private double m;
    private double y;
    private double k;

    public ColorCMYK(double c, double m, double y, double k) {
        if(c < 0.0 || c > 1.0 || m < 0.0 || m > 1.0 || y < 0.0 || y > 1.0 || k < 0.0 || k > 1.0) { //
            System.out.println("Invalid CMYK values");
            // default to white
            c = 0.0;
            m = 0.0;
            y = 0.0;
            k = 0.0;
        }
        this.c = c;
        this.m = m;
        this.y = y;
        this.k = k;
    }

    public double getCyan() {
        return this.c;
    }

    public double getMagenta() {
        return this.m;
    }

    public double getYellow() {
        return this.y;
    }

    public double getBlack() {
        return this.k;
    }

    public boolean isWhite() {
        return this.c == 0.0 && this.m == 0.0 && this.y == 0.0 && this.k == 0.0;
    }
}