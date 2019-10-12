import java.util.*;

class TestApplication {
    public static void main(String[]args) {  
		Scanner input = new Scanner(System.in);

		// Ask user to give us a point
		// Ask user to give us the X value of the point
        System.out.println("Whats the X value?");
		double x = input.nextDouble();
		
		// Ask user to give us the Y value of the point
		System.out.println("Whats the Y value?");
		double y = input.nextDouble();
		
		// Make point 1
		Point point1 = new Point(x,y);

		// Ask user to give us another point
		// Ask user to give the X value of the second point
		System.out.println("Whats the second X value ?");
		x = input.nextDouble();

		// Ask user to give the Y value of the second point
		System.out.println("Whats the second Y value ?");
		y = input.nextDouble();

		// Make point 2
		Point point2 = new Point(x,y);  //important!! to store x y
		
		// print the points out to the user
		System.out.printf("point 1: (%f, %f)\n",point1.getX(),point1.getY());  //when point1 is typed, already created this var
		System.out.printf("point 2: (%f, %f)\n",point2.getX(),point2.getY());


	//test(1)
		// Ask user to move point 1 to another x and y
		// Ask user the x to move to
		System.out.println("What x do you want to move point 1 to ?");
		double moveToX = input.nextDouble();
		
		// Ask user the y to move to
		System.out.println("What y do you want to move point 1 to ?");
		double moveToY = input.nextDouble();

		//move point 1
		point1.moveTo(moveToX,moveToY);  //moveTo FUNCTION will replace value of X and Y again
		
		// print the points out to the user
		System.out.printf("point 1: (%f, %f)\n",point1.getX(),point1.getY());
		System.out.printf("point 2: (%f, %f)\n",point2.getX(),point2.getY());


 //3D point (2)
		// Ask user to give us a 3D point
		// Ask user to give us the X value of the point
        System.out.println("Whats the X value?");
		x = input.nextDouble();
		
		// Ask user to give us the Y value of the point
		System.out.println("Whats the Y value?");
		y = input.nextDouble();
		
		// Ask user to give us the Z value of the point
		System.out.println("Whats the Z value?");
		double z = input.nextDouble(); //make sure set type 

		// Make 3D point 1
		Point3D point3D1 = new Point3D(x,y,z);
		
		// Ask user to give us the X value of the point
        System.out.println("Whats the X value of the second point?");
		x = input.nextDouble();
		
		// Ask user to give us the Y value of the point
		System.out.println("Whats the Y value of the second point?");
		y = input.nextDouble();
		
		// Ask user to give us the Z value of the point
		System.out.println("Whats the Z value of the second point?");
		z = input.nextDouble(); //make sure set type 

		//next 3D point 2
		Point3D point3D2 = new Point3D(x,y,z);

		// print the points out to the user
		System.out.printf("3D point 1: (%f, %f, %f)\n",point3D1.getX(),point3D1.getY(),point3D1.getZ());  //when point1 is typed, already created this var
		System.out.printf("3D point 2: (%f, %f, %f)\n",point3D2.getX(),point3D2.getY(),point3D2.getZ());


	//Testing for (2)
		// Ask user to move 3D point 1 to another x, y, and z
		// Ask user the x to move to
		System.out.println("What x do you want to move 3D point 1 to ?");
		moveToX = input.nextDouble();
		
		// Ask user the y to move to
		System.out.println("What y do you want to move 3D point 1 to ?");
		moveToY = input.nextDouble();

		System.out.println("What z do you want to move 3D point 1 to ?");
		double moveToZ = input.nextDouble(); //creating moveToZ

		//move 3D point 1
		point3D1.moveTo(moveToX,moveToY,moveToZ);  //moveTo FUNCTION will replace value of X and Y and Z again

		// print the points out to the user
		System.out.printf("3D point 1: (%f, %f, %f)\n",point3D1.getX(),point3D1.getY(),point3D1.getZ());  //when point1 is typed, already created this var
		System.out.printf("3D point 2: (%f, %f, %f)\n",point3D2.getX(),point3D2.getY(),point3D2.getZ());

		
		//Test for (3)
		//2D points color using RGB model
		// Ask user to give us the X value of the point
        System.out.println("Whats the X value?");
		x = input.nextDouble();
		
		// Ask user to give us the Y value of the point
		System.out.println("Whats the Y value?");
		y = input.nextDouble();

		// Ask user to give us the R value of the color
		System.out.println("Whats the R value?");
		int r = input.nextInt();

		// Ask user to give us the G value of the color
		System.out.println("Whats the G value?");
		int g = input.nextInt();

		// Ask user to give us the B value of the color
		System.out.println("Whats the B value?");
		int b = input.nextInt();

		// Make RGB color for point 1
		ColorRGB rgb = new ColorRGB(r, g, b);
		
		// Make point 1
		Point point1RGB = new Point(x,y,rgb);


		// Test (7)
		// num of white point may not be zero
		// so we need to reset the counter for white point
		Point.resetNumWhitePoints();   //in Point.java    --> becase resetNumWhitePoints is STATIC

		// Set some white points and some non white points
		// Make 3 white points
		// Make 2 non-white points
		new Point(10, 15, new ColorRGB(255,255,255));  //255 white   //new Point  --> go to Point.java  --> go to the constructor +1, Thats why you dont need Point.
		new Point(10, 15, new ColorRGB(55,25,35));  //random # not white

		// check that it prints there are 3 white points
		Point.printNumWhitePoints();   //in Point.java

	}
}