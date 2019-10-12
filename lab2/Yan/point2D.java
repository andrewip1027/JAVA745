
public class point2D {
	 private float x, y;
   
	   // Constructors
	   public point2D() {  // default constructor
	      this.x = 0;
	      this.y = 0;
	   }
	   public point2D(float x, float y) {
	      this.x= x;
	      this.y = y;
	   }

	   // Get and Set
	   public float getX() {
	      return this.x;
	   }
	   public void setX(float x) {
	      this.x = x;
	   }
	   public float getY() {
	      return this.y;
	   }
	   public void setY(float y) {
	      this.y = y;
	   }
	 
	   public void move (float x, float y) {
		      this.x = x;
		      this.y = y;
		   }
	   
	   // Return "(x,y)"
	  
	}

