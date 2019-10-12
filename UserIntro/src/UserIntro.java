import java.util.Scanner; // import the Scanner class 

public class UserIntro{
	public static void main (String[] args) {   //argument= args   //rmrber cmd must have first parse [] 

        String userName = args[0];
        String airportId = args[1];
        System.out.println("Enter username and number");
        
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
        System.out.println("Hello"+userName+"Welcome to"+airport);
    }
}




