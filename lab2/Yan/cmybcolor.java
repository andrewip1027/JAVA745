
public class cmybcolor extends point3D {
	 private int cyan;
	 private int  magenta;
	 private int yellow;
	 private int black;
	 
	 public cmybcolor() {  // default constructor
	     this.cyan = 0;
	     this.magenta = 0;
	     this.yellow = 0;
	     this.black = 0;
	  }
	  public cmybcolor(int cyan, int magenta,int yellow,int black) {
	     this.cyan = cyan;
	     this.magenta = magenta;
	     this.yellow = yellow;
	     this.black = black;
	     
	  }
	  public void setcolor(int cyan, int magenta,int yellow,int black) {
		     this.cyan = cyan;
		     this.magenta = magenta;
		     this.yellow = yellow;
		     this.black =black;
		     
		  }
	  
	  public int getCyan() {
	     return this.cyan;
	  }
	  public int getMagenta() {
	      return this.magenta;   
	  } 
	  public int getYellow() {
	      return this.yellow ;
	  }
	  public int getBlack() {
	      return this.black;
	  }
	
}
