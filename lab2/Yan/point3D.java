
public class point3D extends point2D{
	 private float z;

	   // Constructors
	   public point3D() {  // default constructor
	      super();     // x = y = 0
	      this.z = 0;
	   }
	   public point3D(float x, float y, float z) {
	      super(x, y);
	      this.z = z;
	   }

	   // Getters and Setters
	   public float getZ() {
	      return this.z;
	   }
	   public void setZ(float z) {
	      this.z = z;
	   }

	   public void move (float x, float y,float z) {
		      
		      this.z = z;
		      super.setX(x);
		      super.setY(y);
		   }
	   // Return "(x,y,z)"
	   //@Override
	  // public String toString() {
	     // return "(" + super.getX() + "," + super.getY() + "," + this.z + ")";
	   //}
}
