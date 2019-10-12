import java.util.*;

public class CartasianSystem {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many points you want to create?");
		int numOfPoints = input.nextInt();
		Point[] point = new Point[numOfPoints];
		
		int x = 0;
		boolean byPass = true;
		boolean notValid = true;
		boolean ongoing = true;
		double xAxis = 0.0;  
		double yAxis = 0.0;
		double zAxis = 0.0;
		int redVal = 0;
		int greenVal = 0;
		int blueVal = 0;
		int cyanVal = 0;
		int magentaVal = 0;
		int yellowVal = 0;
		int keyVal = 0;
		int id = 1000;
		String colourOption = "";
		
		while(x < numOfPoints){
			if(byPass){
				System.out.println("\nPlease specify x value:");
				xAxis = Double.parseDouble(input.next());
				System.out.println("\nPlease specify y value:");
				yAxis = Double.parseDouble(input.next());
				System.out.println("\nPlease specify z value:");
				zAxis = Double.parseDouble(input.next());
			}
			
			System.out.println("\nWhich colour scheme would you choose? RGB/CMYB/skip");
			colourOption = input.next();
			
			if(colourOption.equals("RGB")){
				do{
					System.out.println("\nPlease specify red value:");
					redVal = Integer.parseInt(input.next());
					System.out.println("\nPlease specify green value:");
					greenVal = Integer.parseInt(input.next());
					System.out.println("\nPlease specify blue value:");
					blueVal = Integer.parseInt(input.next());
					
					if(redVal >= 0 && redVal <= 255 && greenVal >= 0 && greenVal <= 255 && blueVal >= 0 && blueVal <= 255){
						point[x] = new Point(id, xAxis, yAxis, zAxis, redVal, greenVal, blueVal);
						notValid = false;
						id++;
						x++;
					}else{
						System.out.println("\nYou have specified invalid values for the colour scheme. Please try again.");
					}
				}while(notValid);
				byPass = true;
			}else if(colourOption.equals("CMYB")){
				do{
					System.out.println("\nPlease specify cyan value:");
					cyanVal = Integer.parseInt(input.next());
					System.out.println("\nPlease specify magenta value:");
					magentaVal = Integer.parseInt(input.next());
					System.out.println("\nPlease specify yellow value:");
					yellowVal = Integer.parseInt(input.next());
					System.out.println("\nPlease specify black value:");
					keyVal = Integer.parseInt(input.next());
					
					if(cyanVal >= 0 && cyanVal <= 100 && magentaVal >= 0 && magentaVal <= 100 && yellowVal >= 0 && yellowVal <= 100 && keyVal >= 0 && keyVal <= 100){
						point[x] = new Point(id, xAxis, yAxis, zAxis, cyanVal, magentaVal, yellowVal, keyVal);
						notValid = false;
						id++;
						x++;
					}else{
						System.out.println("\nYou have specified invalid values for the colour scheme. Please try again.");
					}
				}while(notValid);
				byPass = true;
			}else if(colourOption.equals("skip")){
				point[x] = new Point(id, xAxis, yAxis, zAxis);
				byPass = true;
				id++;
				x++;
			}else{
				System.out.print("\nYou have selected invalid option. Please try again.");
				byPass = false;
			}
		}
		
		do{
			System.out.println("\nPlease select the following options:");
			System.out.println("1. Re-adjust the position of the point");
			System.out.println("2. Reset the colour of the point");
			System.out.println("3. Count the number of white points and non-white points");
			System.out.println("4. Determine the location of the point");
			System.out.println("5. Provide full description about the point");
			System.out.println("6. Exit");
			int option = input.nextInt();
			Point desiredPoint = null;
			
			if(option == 1){
				System.out.println("\nPlease enter the desired point id:");
				int inputId = input.nextInt();
				byPass = true;
				x = 0;
				
				while(x < point.length && byPass){
					if(inputId == point[x].getPointId()){
						desiredPoint = point[x];
						byPass = false;
					}
					x++;
				}
				
				System.out.println("\nPlease re-enter the value of x-axis:");
				xAxis = Double.parseDouble(input.next());
				System.out.println("Please re-enter the value of y-axis:");
				yAxis = Double.parseDouble(input.next());
				System.out.println("Please re-enter the value of z-axis:");
				zAxis = Double.parseDouble(input.next());
				
				desiredPoint.setPosition(xAxis, yAxis, zAxis);
				
				System.out.printf("The resulting position is at %.2f x, %.2f y and %.2f z\n", 
						desiredPoint.getPosition()[0], desiredPoint.getPosition()[1], desiredPoint.getPosition()[2]);
			}else if(option == 2){
				notValid = true;
				
				do{
					if(notValid){
						System.out.println("\nPlease enter the desired point id:");
						int inputId = input.nextInt();
						byPass = true;
						x = 0;
					
						while(x < point.length && byPass){
							if(inputId == point[x].getPointId()){
								desiredPoint = point[x];
								byPass = false;
							}
							x++;
						}
					}
					
					System.out.println("\nWhich colour scheme would you choose? RGB/CMYB");
					colourOption = input.next();
					
					if(colourOption.equals("RGB")){
						do{
							System.out.println("\nPlease specify red value:");
							redVal = Integer.parseInt(input.next());
							System.out.println("\nPlease specify green value:");
							greenVal = Integer.parseInt(input.next());
							System.out.println("\nPlease specify blue value:");
							blueVal = Integer.parseInt(input.next());
							
							if(redVal >= 0 && redVal <= 255 && greenVal >= 0 && greenVal <= 255 && blueVal >= 0 && blueVal <= 255){
								desiredPoint.setRGB(redVal, greenVal, blueVal);
								System.out.printf("The result colours are %d red, %d green and %d blue\n", 
										desiredPoint.getRGB()[0], desiredPoint.getRGB()[1], desiredPoint.getRGB()[2]);
								notValid = false;
							}else{
								System.out.println("\nYou have specified invalid values for the colour scheme. Please try again.");
							}
						}while(notValid);
						byPass = false;
					}else if(colourOption.equals("CMYB")){
						do{
							System.out.println("\nPlease specify cyan value:");
							cyanVal = Integer.parseInt(input.next());
							System.out.println("\nPlease specify magenta value:");
							magentaVal = Integer.parseInt(input.next());
							System.out.println("\nPlease specify yellow value:");
							yellowVal = Integer.parseInt(input.next());
							System.out.println("\nPlease specify black value:");
							keyVal = Integer.parseInt(input.next());
							
							if(cyanVal >= 0 && cyanVal <= 100 && magentaVal >= 0 && magentaVal <= 100 && yellowVal >= 0 && yellowVal <= 100 && keyVal >= 0 && keyVal <= 100){
								desiredPoint.setCMYK(cyanVal, magentaVal, yellowVal, keyVal);
								System.out.printf("The result colours are %d percent cyan, %d percent magenta, %d percent yellow and %d percent black\n", 
										desiredPoint.getCMYK()[0], desiredPoint.getCMYK()[1], desiredPoint.getCMYK()[2], desiredPoint.getCMYK()[3]);
								notValid = false;
							}else{
								System.out.println("\nYou have specified invalid values for the colour scheme. Please try again.");
							}
						}while(notValid);
						byPass = false;
					}else{
						System.out.print("\nYou have selected invalid option. Please try again.");
						byPass = true;
						notValid = false;
					}
				}while(byPass);
			}else if(option == 3){
				int result = 0;
				boolean rgbWhite = false;
				boolean cmykWhite = false;
				byPass = true;
				
				for(int z = 0; z < point.length; z++){
					if(point[z].getRGB()[0] == 255 && point[z].getRGB()[1] == 255 && point[z].getRGB()[2] == 255){
						rgbWhite = true;
					}
					
					if(point[z].getCMYK()[0] == 0 && point[z].getCMYK()[1] == 0 && point[z].getCMYK()[2] == 0 && point[z].getCMYK()[3] == 0){
						cmykWhite = true;
					}
					
					if(rgbWhite && cmykWhite){
						result = result + 1;
					}
					rgbWhite = false;
					cmykWhite = false;
				}
				
				System.out.printf("There is %d white points and %d non-white points in the system.\n", result, point.length - result);
			}else if(option == 4){
				System.out.println("\nPlease enter the desired point id:");
				int inputId = input.nextInt();
				byPass = true;
				x = 0;
				
				while(x < point.length && byPass){
					if(inputId == point[x].getPointId()){
						desiredPoint = point[x];
						byPass = false;
					}
					x++;
				}
				
				if(desiredPoint.getPosition()[2] == 0){
					System.out.println("The point is in a two dimensional (2D) space.");
				}else if(desiredPoint.getPosition()[2] > 0 || desiredPoint.getPosition()[2] < 0){
					System.out.println("The point is in a three dimensional (3D) space.");
				}
			}else if(option == 5){
				System.out.println("\nPlease enter the desired point id:");
				int inputId = input.nextInt();
				byPass = true;
				x = 0;
				
				while(x < point.length && byPass){
					if(inputId == point[x].getPointId()){
						desiredPoint = point[x];
						byPass = false;
					}
					x++;
				}
				
				if(desiredPoint.getRGB()[0] < 255 || desiredPoint.getRGB()[1] < 255 || desiredPoint.getRGB()[2] < 255){
					if(desiredPoint.getPosition()[2] == 0){
						System.out.println("\n2D point coloured using RGB model");
					}else if(desiredPoint.getPosition()[2] > 0 || desiredPoint.getPosition()[2] < 0){
						System.out.println("\n3D point coloured using RGB model");
					}
				}else if(desiredPoint.getCMYK()[0] > 0 || desiredPoint.getCMYK()[1] > 0 || desiredPoint.getCMYK()[2] > 0 || desiredPoint.getCMYK()[3] > 0){
					if(desiredPoint.getPosition()[2] == 0){
						System.out.println("\n2D point coloured using CMYB model");
					}else if(desiredPoint.getPosition()[2] > 0 || desiredPoint.getPosition()[2] < 0){
						System.out.println("\n3D point coloured using CMYB model");
					}
				}
			}else if(option == 6){
				System.out.println("Thank you. Have a nice day!");
				ongoing = false;
			}else{
				System.out.println("This is not a valid option. Please try again.");
			}
		}while(ongoing);
	}
}
