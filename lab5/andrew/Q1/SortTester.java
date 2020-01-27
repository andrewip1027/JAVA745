//b)	create  SortTester which you will use to conduct your experiment

/*Create a class called SortTester which you will use to conduct your experiments. 
In the main() method, you should create a configurable number of objects. 
Allow the value to be passed into the program as a parameter. 
As you create the objects, place them in an array (not acollection). */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SortTester {
    public static void main (String args[]) throws IOException { 
//	int result = Integer.parseInt(number);			
        
        int numObjects = Integer.parseInt(args[0]); //convert string to interger

        //array var-name = new type [size];

        //Reading is our Reading.java
        Reading[] objArray = new Reading [numObjects];   //numObjects our new variable 
        
        //Each index need new object so we use FOR loop
        //for (int i = 0; i < 5; i++) {

        for (int i = 0; i < numObjects; i++) { 
            objArray[i] = Reading.createObject();  //from Reading.java
        }

        // TODO: ask user to select a sort method
        /*SCANNER for Sort Method BEGINS HERE*/

        Scanner userInput = new Scanner(System.in);

        do{
            System.out.print("Please select the sort method: 'merge' or 'insertion'");
            String sortMethod = userInput.nextLine();
            System.out.println(sortMethod);
            if (sortMethod.equals("merge")) { 
                System.out.println("merge sort method selected.");
                //then execute merge sort
                mergeSort(objArray);
                break;
            }
            else if(sortMethod.equals("insertion")) {
                System.out.println("insertion sort method selected.");    
                insertionSort(objArray);
                break;
            }
            else System.out.println("Wrong entry, please retype.");
        }
        while(true);  //keep looping until break.

        // print the sorted array into a text file.
        FileWriter fw = new FileWriter("out.txt");
        
        // for (type variable : arrayname)
        
        for (int i = 0; i < numObjects; i++) {
            fw.write(objArray[i].toString() + "\n");
        }
     //
        fw.close();

    }

    /*
    In another static method, implement the insertion sort as described in section 19.7 of the text.
Order is based on the windspeed, then the temperature. Measure the elapsed time needed for the
algorithm to execute using something like System.nanoTime(). Do the same for the merge sort (as in 19.8)
    */
    private static void merge(Reading[] data, int low, int middle1, int middle2, int high){ 
        int leftArrayIndex = low; // pointing to which index we are looking at in the left side array
        int rightArrayIndex = middle2; // pointing to which index we are looking at in the right side array
        Reading[] merged = new Reading[high - low + 1]; // array to put results of merging
        for(int i = 0; i < merged.length; i++) {
            if(leftArrayIndex > middle1) {
                // fill in element from right array
                merged[i] = data[rightArrayIndex];
                rightArrayIndex += 1;
            }
            else if(rightArrayIndex > high) {
                // fill in element from left array
                merged[i] = data[leftArrayIndex];
                leftArrayIndex += 1;
            }
            else {
                if(data[leftArrayIndex].windspeed < data[rightArrayIndex].windspeed || 
                    (data[leftArrayIndex].windspeed == data[rightArrayIndex].windspeed && data[leftArrayIndex].temp < data[rightArrayIndex].temp)) {
                    // fill in element from left array
                    merged[i] = data[leftArrayIndex];
                    leftArrayIndex += 1;
                }
                else {
                    // fill in element from right array
                    merged[i] = data[rightArrayIndex];
                    rightArrayIndex += 1;
                }
             }
        }

        // put each element in merged array back into data array
        for(int i = 0; i < merged.length; ++i) { 
            data[low + i] = merged[i];
        }
    }

    private static void mergeSortArray(Reading[] data, int low, int high){
        // TODO: implement recursive merge sort 
        //copy pdf 30 - 48 
        //test base case; size of array equals 1
        if((high - low) >= 1) //IF NOT BASE CASE
        {
            int middle1 = (low + high) /2; //calculate middle of array
            int middle2 = middle1 + 1; //calculate next element over
        
            // split array in half; sort each half (recursive calls)
            mergeSortArray(data, low, middle1); // first half of array
            mergeSortArray(data, middle2, high); // second half of array
  
             // merge two sorted arrays after split calls return
            merge(data, low, middle1, middle2, high); //call merge function
            // System.out.println("split" + subarray(low, high));
        }
    }
    
    //MERGE SORT BEGIN - calls sort Array method to begin mergeSort 
    private static void mergeSort (Reading[] data) { 
        // start time
        long startTime = System.nanoTime();
        
        mergeSortArray(data, 0, data.length - 1);
        
        // end time
        long endTime = System.nanoTime();

        // print elapsed time
        System.out.println("Time to execute merge sort (nanoSeconds): " + (endTime - startTime));
    }
        


    //INSERTION SORT BEGIN HERE
    private static void insertionSort (Reading[] data) {  //pass Reading[]  
        // start time
        long startTime = System.nanoTime();

        
        // temporary variable to hold element to insert
        Reading insert;
        //loop over data.length -1 elements 
        for (int next = 1; next <data.length; next++)
        {
            insert = data[next];

            int moveItem = next;

            /*

         original   (w = 50, temp = 21)  (w = 30, temp = 12)  (w = 50, temp = 11)
                    (w = 30, temp = 12)  (w = 50, temp = 21)  (w = 50, temp = 11)
         sorted     (w = 30, temp = 12)  (w = 50, temp = 11)  (w = 50, temp = 21)  

            */
            while(moveItem > 0 && 
                (  //compare windspeed and temp INSIDE READING
                    data[moveItem - 1].windspeed > insert.windspeed ||  /*this code move higher WS to the right element */
                    (data[moveItem - 1].windspeed == insert.windspeed && data[moveItem - 1].temp > insert.temp) //if WS == Compared WS then sort TEMP
                ))              
            { 
                //shift element right one slot
                data[ moveItem ] = data [moveItem - 1];
                moveItem--; 
            } //end while
            data [moveItem] = insert; //place inserted element

        } //end for  

        //Order is based on the windspeed, then the temperature.

        //Measure the elapsed time needed for the algorithm to execute using something like System.nanoTime()


        // end time
        long endTime = System.nanoTime();

        // print elapsed time
        System.out.println("Time to execute insertion sort (nanoSeconds): " + (endTime - startTime));
    }

    //Do the same for the merge sort (as in 19.8)


    //Variable declaration for sorting algorithm (EXECUTION TIME ONLY)
    public static long duration;
    public static long startTime;
    public static long endTime;
//a)	Use the given Reading class to create objects.


   

}

	
	
	


