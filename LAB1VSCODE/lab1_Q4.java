/* Create a ‘Marks Calculator’ application. This application must calculate a final grade for each entered student. Your program must loop until all students have been entered. For each student,the following must be entered...
*/
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 @Description of what the program do:
 This marks calculator program calculate the final score and grade for each student, and the class average and percentages of each grade for all students.
 Enter the student name and his/her scores and then the program will output his/her percentages, final score, and grade.
 Enter an empty line when asked for a student name when you've finished entering scores for all students.
 After scores for all students are entered, the class average and the percentages of students getting each grade is calculated and displayed to system output.
 
 @author  Andrew Ip
 @version 1.0
 @since   2019-09-17 
 */
public class lab1_Q4 { 
    /**
     This is the main method for this program.
     
     @param args Unused 
     @return Nothing.
    */
    public static void main(String[] args) {
        float Aplus= 0;
        float A= 0;
        float Bplus= 0;
        float B= 0;
        float Cplus= 0;
        float C= 0;
        float Dplus= 0;
        float D= 0;
        float F= 0;
        float classAverage = 0;
        int studentCount = 0;
        
        while(true) {
            Scanner input = new Scanner(System.in);

            //Variable declaration
            String studentName, Grade, gradeFinal, dropedTest;
            float assignment1,assignment2,test1,test2,test3,labs,examFinal,scoreFinal,assignmentTotal,testSum = 0;

            //1Step: Ask the user 
            System.out.println("Student Name: ");
            studentName = input.nextLine();
            if(studentName.isEmpty()) break;

            studentCount++;

            System.out.println("Assignment 1: ");
            assignment1 = input.nextFloat();
            System.out.println("Assignment 2: ");
            assignment2 = input.nextFloat();
            System.out.println("Test 1: ");
            test1 = input.nextFloat();
            System.out.println("Test 2: ");
            test2 = input.nextFloat();
            System.out.println("Test 3: ");
            test3 = input.nextFloat();
            System.out.println("Labs: ");
            labs = input.nextFloat();
            System.out.println("Final Exam: ");
            examFinal=input.nextFloat();  //Get user input *rmber is float 

            /* a code that drops the least of the three test*/
            if ((test1 <= test2)&&(test1<=test3)) {
                testSum = test2 + test3;
                dropedTest = "Test1";
            }
            else if ((test2 <= test1) && (test2 <= test3)) {
                testSum = test1 + test3;
                dropedTest = "Test2";
            }
            else if ((test3 <= test2) && (test3 <= test2)) {
                testSum = test1 + test2;
                dropedTest = "Test3";
            }

            scoreFinal = (assignment1 / 100 * 10) + 
                (assignment2 / 100 * 10) + 
                (testSum / 100 * 15) + 
                labs + 
                (examFinal / 100 * 30);

            classAverage += scoreFinal;

            //2Step
            
            //a Student name
            double courses = assignment1 + assignment2 + labs + testSum; 

            if(examFinal < 50 || 
                (assignment1 < 50 && assignment2 < 50 && 
                    test1 < 50 && test2 < 50 && test3 < 50 && 
                    labs < 10) || 
                scoreFinal < 50) {
                Grade = "F";
                F++;
            }
            else if((scoreFinal >= 90) && (scoreFinal <= 95.99)) {
                Grade = "A+";
                Aplus++;
            }
            else if((scoreFinal >= 80)&& (scoreFinal<=85.99)) {
                Grade = "A";
                A++;
            }
            else if((scoreFinal >= 75)&& (scoreFinal<=79.99)) {
                Grade = "B+";
                Bplus++;
            }
            else if((scoreFinal >= 70)&& (scoreFinal<=74.99)) {
                Grade = "B";
                B++;
            }
            else if((scoreFinal >=65)&& (scoreFinal<=69.99)) { 
                Grade = "C+";
                Cplus++;
            }
            else if((scoreFinal >=60)&& (scoreFinal<=64.99)){
                Grade = "C";
                C++;
            }
            else if((scoreFinal >= 55)&& (scoreFinal <=59.99)){
                Grade = "D+";
                Dplus++;
            }
            else {
                Grade = "D";
                D++;
            }
            gradeFinal = Grade;
            
            //Print ALL final score
            System.out.println("Student Name: " + studentName + 
                " Assignment 1: " + assignment1 + "%\n" + 
                " Assignment 2: " + assignment2 + "%\n" +
                "Test 1: " + test1 + "%\n" +
                "Test 2: " + test2 + "%\n" + 
                "Test 3: " + test3 + "%\n" +
                "Labs: "+ labs/20*100 + "%\n" + 
                "Final Exam: " + examFinal + "%\n" +
                "Your Score: " + scoreFinal + "%\n" +
                "Grade: " + gradeFinal);

        }
        if(studentCount > 0) {  //
            classAverage = classAverage / studentCount;

            Aplus = Aplus / studentCount * 100;
            A = A / studentCount * 100;
            Bplus = Bplus / studentCount * 100;
            B = B / studentCount * 100;
            Cplus = Cplus / studentCount * 100;
            C = C / studentCount * 100;
            Dplus = Dplus / studentCount * 100;
            D = D / studentCount * 100;
            F = F / studentCount * 100;

            System.out.println("Letter grade percentage:\n" +
                "A+: " + Aplus + "%\n" +
                "A: " + A + "%\n" +
                "B+: " + Bplus + "%\n" +
                "B: " + B + "%\n" +
                "C+: " + Cplus + "%\n" +
                "C: " + C + "%\n" +
                "D+: " + Dplus + "%\n" +
                "D: " + D + "%\n" +
                "F: " + F + "%");
            
            System.out.println("Class average: " + classAverage + "%");
        }
    }
}
        