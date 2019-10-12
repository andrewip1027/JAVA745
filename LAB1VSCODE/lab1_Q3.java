/* In a class named Quiz, create a multiple choice game for students in our class. It will have 5
 questions based on the course material thus far. Final results should be posted upon completion.
 The user should be able to choose whether the answers are shown at the end of the test or not.
 How this choice is selected should be noted in the documentation.

 @author  Andrew Ip
 @version 1.0
 @since   2019-09-17 

 */ 

import java.util.*;
public class lab1_Q3 {
    /**
     This is the main method for this program.
     
     @param args Unused 
     @return Nothing.
    */
	public static void main(String[] args) {
        
            System.out.println("Welcome to the 5 question testing! /n  Would you like the answers shown at the end of the test or not?");
            Scanner input = new Scanner(System.in);
            /*

            int  ;   //take the answer from user 
            if(answer = yes)  //if yes store it and print it at the end
            */
            // this is where you initialize the Scanner

            //What is the prefer IDE for this course 
            // this is the shorter way to initialize the array
            // but they do the same thing
            // the array is called "q1Choices"
            //Q1
            System.out.println("What is the prefered IDE for this course?");
            
            String[] q1Choices = new String[] {
                "Eclipse",
                "VS Code",
                "Blue J",
                "python shell",
                "Sublime text"
            };
            // print Q1 choices
            for (int i=0; i<5; i++)
                System.out.println((i + 1) + ". " + q1Choices[i]); //index 0 print 1|index 1 print 2   
            // you'll first need to get an input from user
            // since you've already initialized a Scanner, you can do this:
            int select = input.nextInt(); //user input 1
            // then now "select" contains the user's answer
            if(select == 1)
                System.out.println(q1Choices[0] + " is correct!");   //output = string as well
            else
                System.out.println(q1Choices[select-1]+ " is not correct");
            //Q2 
            System.out.println("AA");
        
            String[] q2Choices = new String[] {
                "A",
                "VS Code",
                "Blue J",
                "python shell",
                "Sublime text"
            };
            for (int i=0; i<5; i++)
                System.out.println((i + 1) + ". " + q2Choices[i]); //index 0 print 1|index 1 print 2   
            // you'll first need to get an input from user
            // since you've already initialized a Scanner, you can do this:
            select = input.nextInt(); //user input 1 , new input values
            // then now "select" contains the user's answer
            if(select == 2)
                System.out.println(q2Choices[1] + " is correct!");   //output = string as well
            else
                System.out.println(q2Choices[select-1]+ " is not correct");

            //Q3
            System.out.println("33333?");
            
            String[] q3Choices = new String[] {
                "AA",
                "VS Code",
                "33",
                "python shell",
                "Sublime text"
            };
            // print Q3 choices
            for (int i=0; i<5; i++)
                System.out.println((i + 1) + ". " + q3Choices[i]); //index 0 print 1|index 1 print 2   
            // you'll first need to get an input from user
            // since you've already initialized a Scanner, you can do this:
            select = input.nextInt(); //user input 1
            // then now "select" contains the user's answer
            if(select == 3)
                System.out.println(q3Choices[2] + " is correct!");   //output = string as well
            else
                System.out.println(q3Choices[select-1]+ " is not correct");

            //Q4
            System.out.println("44?");
            
            String[] q4Choices = new String[] {
                "Eclipse",
                "VS Code",
                "Blue J",
                "4",
                "Sublime text"
            };
            // print Q4 choices
            for (int i=0; i<5; i++)
                System.out.println((i + 1) + ". " + q4Choices[i]); //index 0 print 1|index 1 print 2   
            // you'll first need to get an input from user
            // since you've already initialized a Scanner, you can do this:
            select = input.nextInt(); //user input 1
            // then now "select" contains the user's answer
            if(select == 4)
                System.out.println(q4Choices[3] + " is correct!");   //output = string as well
            else
                System.out.println(q4Choices[select-1]+ " is not correct");

            //Q5
            System.out.println("5?");
            String[] q5Choices = new String[] {
                "Eclipse",
                "VS Code",
                "Blue J",
                "python shell",
                "5"
            };
            // print Q5 choices
            for (int i=0; i<5; i++)
                System.out.println((i + 1) + ". " + q5Choices[i]); //index 0 print 1|index 1 print 2   
            // you'll first need to get an input from user
            // since you've already initialized a Scanner, you can do this:
            select = input.nextInt(); //user input 1
            while(select > 5 || select < 1) {
                System.out.println("invalid input, please try again");
                select = input.nextInt();
            }

            // then now "select" contains the user's answer
            if(select == 5)
                System.out.println(q5Choices[4] + " is correct!");   //output = string as well
            else
                System.out.println(q5Choices[select-1] + " is not correct");
    }
}

//if statment of correct answer..else wrong answer 
//multiplechoice = new String[5]
        //if userselect = multichoice[0];)   system print
        
        //Ask if the score shown at the end -> enter yes or no option

        //Tell user a b c d is the choices
        // System.out.println("You can choose a b c d as a multiple choice.");  
        //Print out the questions "..+..."

        //Print out the score 
        
