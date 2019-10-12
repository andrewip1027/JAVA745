//Date: Sep 12th, 2019
//@author Andrew Ip
//@Description of what the program do: This is a program for the user to input their name and type a number from 1 to 4, and if other numbers was inputed it will print out airport names. 
//@if something fail explain why
//@run config --> Java application, make sure run argument(since prof doesnt add input)
//@Send the single file  At the end Submit all 5 files 
package lab1;

public class UserIntro {

	public static void main(String[] args) {
		
		String userName = args[0];
        String airportId = args[1];
        
        String airport="";
        
        
        switch (airportId) {
            case "1":
            airport = "Lester B. Pearson Airport";
            break;

            case "2": 
            airport = "Billy Bishop Airport";
            break;

            case "3": 
            airport = "John Munro Airport";
            break;

            case "4": 
            airport = "Waterloo Airport";
            break;
            
            default:
            System.out.println("Input error");
            break;
        }	
        System.out.println("Hello "+userName+" Welcome to" +airport); 

	}

	
	
}



