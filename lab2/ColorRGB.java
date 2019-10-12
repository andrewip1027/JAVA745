public class ColorRGB extends Color {
    private int r;
    private int g;
    private int b;

    public ColorRGB(int r, int g, int b) {
        if(r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            System.out.println("Invalid RGB values");
            // default to white
            r = 255;
            g = 255;
            b = 255;
        }
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getRed() {
        return this.r;
    }

    public int getGreen() {
        return this.g;
    }

    public int getBlue() {
        return this.b;
    }

    public boolean isWhite() {
        return this.r == 255 && this.g == 255 && this.b == 255;
    }
}