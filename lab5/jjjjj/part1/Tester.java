import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tester {

    //variables for calculating sorting algorithm execution time
    public static long duration;
    public static long startTime;
    public static long endTime;
    
    //determine if a string is a number entered
    public static boolean isNumeric(String strNum) {
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException | NullPointerException nfe) {
        return false;
    }
    	return true;
    }
    
    // splits array, sorts subarrays and merges subarrays into sorted array
    private static void sortArray(Reading[] data, int low, int high) {
         // test base case; size of array equals 1
         if ((high - low) >= 1) { // if not base case
            int middle1 = (low + high) / 2; // calculate middle of array
            int middle2 = middle1 + 1; // calculate next element over

            // split array in half; sort each half (recursive calls)
            sortArray(data, low, middle1); // first half of array
            sortArray(data, middle2, high); // second half of array
 
            // merge two sorted arrays after split calls return
            merge (data, low, middle1, middle2, high);
         }
    }

    // merge two sorted subarrays into one sorted subarray
    private static void merge(Reading[] data, int left, int middle1,
         int middle2, int right) {

         int leftIndex = left; // index into left subarray
         int rightIndex = middle2; // index into right subarray
         int combinedIndex = left; // index into temporary working array
         Reading[] combined = new Reading[data.length]; // working array

         // merge arrays until reaching end of either
         while (leftIndex <= middle1 && rightIndex <= right) {
            // place smaller of two current elements into result
            // and move to next space in arrays
            if (data[leftIndex].windspeed <= data[rightIndex].windspeed) {  
               combined[combinedIndex++] = data[leftIndex++];
            }else{
               combined[combinedIndex++] = data[rightIndex++];
            }
         }

         // if left array is empty
         if (leftIndex == middle2) {
            // copy in rest of right array
            while (rightIndex <= right) {
               combined[combinedIndex++] = data[rightIndex++];
            }
         }
         else { // right array is empty
            // copy in rest of left array
            while (leftIndex <= middle1) {
               combined[combinedIndex++] = data[leftIndex++];
            }
         }

         // copy values back into original array
         for (int i = left; i <= right; i++) {
            data[i] = combined[i];
         }
         
    }
    //LAST PART WHERE WE WRITE FILES THEN PART2 WILL READ THE FILE TO BUFFER  
    //write the result of a sorted array to a file for loop 
    private static void WriteToFile(Reading[] array, String sortType, long executionTime) throws IOException{
        FileWriter fw = new FileWriter(sortType + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        
        //output the information on the size of array and sorting method employed
        bw.write("Array size: " + array.length);
        bw.newLine();
        bw.write("Sorting Method: " + sortType);
        bw.newLine();
        bw.newLine();
        
        //output each element of the sorted array
        for(int i = 0; i < array.length; i++){
            bw.write(array[i].toString());
            bw.newLine();
        }
        
        //output the sorting algorithm execution time
        bw.newLine();
        bw.write("Execution time is " + executionTime + " nanoseconds.");  
        bw.close();
    }
    
    public static void InsertionSort(Reading[] data) {  //must change reading object  to nsertion sort and read file
         startTime = System.nanoTime(); 
         // loop over data.length - 1 elements
         for (int next = 1; next < data.length; next++) {
            Reading insert = data[next]; // value to insert
            int moveItem = next; // location to place element
            
            // search for place to put current element
            while (moveItem > 0 && data[moveItem - 1].windspeed > insert.windspeed) {
                // shift element right one slot
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            }
            
            data[moveItem] = insert; // place inserted element
         }
         endTime = System.nanoTime();

	 //calculate the execution time of insertion sort
         duration = endTime - startTime;
         
         //output the result of a sorted array to a file
         try{
            WriteToFile(data,"InsertionSort", duration);
            System.out.println("Result has been successfully outputted to a file.");
         }catch(IOException io){
            System.out.println("Result cannot be outputted to a file.");
         }
    }

    // calls recursive sortArray method to begin merge sorting
    public static void MergeSort(Reading[] data) {
        startTime = System.nanoTime();
        sortArray(data, 0, data.length - 1); // sort entire array
        endTime = System.nanoTime();

	//calculate the execution time of merge sort
        duration = endTime - startTime;

	//output the result of a sorted array to a file
        try{
            WriteToFile(data,"MergeSort", duration);
            System.out.println("Result has been successfully outputted to a file.");
        }catch(IOException io){
            System.out.println("Result cannot be outputted to a file.");
        }
    }
    this whole part can be shortend, use Try catch instead 
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Reading[] rArray = null;
        String arraySize;
        String selection;
        boolean processing = true;
	    int i = 0;
        int max = 4; 
        int min = 1; 
        int range = max - min + 1;
        
        //specify the size of an array
        do{
            System.out.print("Specify the size of an array: ");
            arraySize = userInput.nextLine();
            
            if(isNumeric(arraySize)){
                if(Integer.parseInt(arraySize) > 0){
                    rArray = new Reading[Integer.parseInt(arraySize)];
                    processing = false;
                }else{
                    System.out.println("Array size has to be a positive integer. Please try again.");
                }
            }else{
                System.out.println("Wrong input. Please try again.");
            }
            
        }while(processing);
        
        //populating the array with Reading objects
	while(i < rArray.length) {
            int j = (int)(Math.random() * range) + min; 
            
            if(j == 1) {
		rArray[i] = Reading.createObject(Location.NE);
            }else if(j == 2) {
		rArray[i] = Reading.createObject(Location.NW);
            }else if(j == 3) {
		rArray[i] = Reading.createObject(Location.SE);
            }else if(j == 4) {
                rArray[i] = Reading.createObject(Location.SW);
            }
            i++;
	}
	
        System.out.print("\n");
        processing = true;
        
        //user selection for a sorting algorithm
        do{
            System.out.print("Select a sorting algorithm:\n1) Insertion Sort\n2) Merge Sort\nEnter 1 or 2 for selection: ");
            selection = userInput.nextLine();
            
            if(isNumeric(selection)){
                if(Integer.parseInt(selection) == 1){
                    InsertionSort(rArray);
                    processing = false;
                }else if(Integer.parseInt(selection) == 2){
                    MergeSort(rArray);
                    processing = false;
                }else{
                    System.out.println("Wrong selection. Please try again.");
                }
            }else{
                System.out.println("Wrong input. Please try again.");
            }
        }while(processing);        
    }
}