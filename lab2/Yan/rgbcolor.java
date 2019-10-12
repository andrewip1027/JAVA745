
public class rgbcolor extends point3D {
 private int r;
 private int g;
 private int b;
 
 public rgbcolor() {  // default constructor
     this.r = 255;
     this.g = 255;
     this.b = 255;
  }
  public rgbcolor(int r, int g,int b) {
     this.r = r;
     this.g = g;
     this.b = b;
     
  }
  
  public void setcolor(int r, int g,int b) {
	     this.r = r;
	     this.g = g;
	     this.b = b;
	     
	  }
  public int getRed() {
     return this.r ;
  }
  public int getGreen() {
      return this.g ;   
  } 
  public int getBlack() {
      return this.b ;
  }

}
