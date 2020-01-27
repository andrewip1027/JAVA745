public class Point {
	private int pointId = 0;
	private double xPos = 0.0;
	private double yPos = 0.0;
	private double zPos = 0.0;
	private int red = 255;
	private int green = 255;
	private int blue = 255;
	private int cyan = 0;
	private int magenta = 0;
	private int yellow = 0;
	private int key = 0;
	
	public Point(int id, double x, double y, double z){
		this.pointId = id;
		this.xPos = x;
		this.yPos = y;
		this.zPos = z;
	}
	
	public Point(int id, double x, double y, double z, int r, int g, int b){
		this.pointId = id;
		this.xPos = x;
		
		this.yPos = y;
		this.zPos = z;
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	
	public Point(int id, double x, double y, double z, int c, int m, int yl, int k){
		this.pointId = id;
		this.xPos = x;
		this.yPos = y;
		this.zPos = z;
		this.cyan = c;
		this.magenta = m;
		this.yellow = yl;
		this.key = k;
	}
	
	public int getPointId(){
		return this.pointId;
	}
	
	public double[] getPosition(){
		double[] position = new double[]{this.xPos, this.yPos, this.zPos};
		return position;
	}
	
	public int[] getRGB(){
		int[] rgb = new int[]{this.red, this.green, this.blue};
		return rgb;
	}
	
	public int[] getCMYK(){
		int[] cmyk = new int[]{this.cyan, this.magenta, this.yellow, this.key};
		return cmyk;
	}
	
	public void setPosition(double x, double y, double z){
		this.xPos = x;
		this.yPos = y;
		this.zPos = z;
	}
	
	public void setRGB(int r, int g, int b){
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	
	public void setCMYK(int c, int m, int yl, int k){
		this.cyan = c;
		this.magenta = m;
		this.yellow = yl;
		this.key = k;
	}
}