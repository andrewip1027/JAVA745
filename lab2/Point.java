public class Point {
    private double x;
    private double y;
    private Color color;

    private static int numWhitePoints = 0;

    public Point(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        if(this.color.isWhite()) numWhitePoints += 1;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.color = new ColorRGB(255, 255, 255);
        numWhitePoints += 1;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setColor(Color color) {
        if(this.color.isWhite()) numWhitePoints -= 1;
        this.color = color;
        if(this.color.isWhite()) numWhitePoints += 1;
    }

    public static void resetNumWhitePoints() {
        numWhitePoints = 0;
    }

    public static void printNumWhitePoints() {
        System.out.printf("Number of white points: %d\n", numWhitePoints);
    }
}