import java.sql.Date;

//hi
/*
3.16
(target heart rate calculator) While excercising, you can use a heart rate monitor to see that your heart rate stays within a safe range suggested by your trainers and doctors. According to the American Heart Association (AHA) (http://bit.ly/TargetHeartRates), the formula for calculating your maximum heart rate in beats per minute is 220 minus your age in years. Your target heart rate is a range thats 50 - 85% of your maximum heart rate. */

/*SECTION Write a java app that prompts for the persons information, instantiates an object of class Heart Rates and prints the information from the object - including the person's first name, last name and date of birth -- then calculates and prints the person's age in (years), maximum heart rate and target heart - rate range. 
*/


/*SECTION 
Create a class called Heart rate. The class attributes should include the person's first name, last name, and date of birth (consisting of separate attributes for the month, day and year of birth) 
*/
public class heartRate {
    private String firstName = "";  //set empty string
    private String lastName = "";

    private int dateBirth; //month, day, year
    private int month; 
    private int day;
    private int year;  

// do{
//     System.out.print("please enter the province code");
//     if() {

//     }
    

//Max HR :  Beat per Min = 220 - 25 = 195 
//50 - 85% of max heart rate 

/*SECTION  Your class should have a constructor that receives this data as parameters.*/ 
    public heartRate(String firstName, String lastName, int dateBirth){
        this.firstName = firstName; 
        this.lastName= lastName;
        this.dateBirth= dateBirth;
    }


//SECTION  For each attribute provide set and get methods.  
    private void setFirstName(String firstName){
        this.firstName = firstName;
    }
    private int getFirstName(String firstName){
        return this.firstName;
    }




/*SECTION The class also should include a method that 
(a)calculates and returns the person's age (in years), (b) a method that calculates and returns the person's maximum heart rate and (c)a method that calculates and returns the person's target heart rate */
//STUB (a)
public personAge (int , String){

}


//STUB  (b)
public maxHeartRate(int , ){

}

//STUB (c)
public targetHeartRate (int, ){
    
}

