import java.util.*;
import java.util.Scanner;
/*
3.16
(target heart rate calculator) While excercising, you can use a heart rate monitor to see that your heart rate stays within a safe range suggested by your trainers and doctors. According to the American Heart Association (AHA) (http://bit.ly/TargetHeartRates), the formula for calculating your maximum heart rate in beats per minute is 220 minus your age in years. Your target heart rate is a range thats 50 - 85% of your maximum heart rate. */

/*SECTION a) Write a java app that prompts for the persons information, instantiates an object of class Heart Rates and prints the information from the object - including the person's first name, last name and date of birth -- 
b) then calculates and prints the person's age in (years),  c) maximum heart rate and target heart - rate range. 
*/

/*SECTION a
Create a class called Heart rate. The class attributes should include the person's first name, last name, and date of birth (consisting of separate attributes for the month, day and year of birth) 
*/

public class heartRate {
    public String firstName;
    public String lastName;
    public int age;

    public static void main( String[] args) {
        Scanner input = new Scanner (System.in);
        heartRate person1 = new heartRate();

        System.out.println("Enter first name");  //Ask user first name
        person1.firstName = input.nextLine(); 

        System.out.println("Enter last name");  //Ask user first name
        person1.lastName = input.nextLine(); 

        System.out.println("Enter your age: ");
        person1.age = input.nextInt();
//b

        System.out.printf( "Calculations for %s age %d\n", person1.getFirstName(), person1.getAge() );

        //c //Max HR :  Beat per Min = 220 - 25 = 195      //50 - 85% of max heart rate 
        System.out.printf(" Max Heart Rate: %d Beats per minute\n", person1.getMaxHeartRate() ); 
      
        System.out.printf( "Max Target Heart Rate Range is: %d\n", person1.getMaxTargetHeartRate() );

        System.out.printf( "Min Target Heart Rate Range is: %d\n", person1.getMinTargetHeartRate() );
        //NOTE Use this to print remember plz 
    }


        // Your target heart rate is a range thats 50 - 85% of your maximum heart rate. 
    public int getMaxTargetHeartRate(){
        int maxTargetHeartRate = (int)(getMaxHeartRate() * 0.85);
        return maxTargetHeartRate;
    }
    
    public int getMinTargetHeartRate(){
        int minTargetHeartRate = (int)(getMaxHeartRate() * 0.5);
        return minTargetHeartRate;
    }

    public int getMaxHeartRate() {
    // the formula for calculating your maximum heart rate in beats per minute is 220 minus your age in years
    //NOTE just need int to declare variable in java    
    int maxHeartRate = 220 - age; 
        return maxHeartRate;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

}