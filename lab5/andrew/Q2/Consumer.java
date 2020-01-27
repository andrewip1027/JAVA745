import java.io.FileWriter;
import java.io.IOException; 

public class Consumer implements Runnable {

    private final String name;
    private final Buffer buffer;

    public Consumer(String name, Buffer buffer) {
        this.name = name;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try { 
            // we only need to open the file once, so we can put this outside of the do-while loop
            // now the problem with Consumer is that all Consumer threads are gonna write to the same file
            // so we need a different file name for different consumer
            // so we need a constructor that pass in a name so that we can use the name as this file name
            FileWriter fw = new FileWriter(name + ".txt");

            // Get Reading object from buffer and write it to file
            // continue doing this forever until failed to get object
            do {
                Reading readingObj = buffer.get();
                
                if(readingObj == null) {
                    // failed to get object from buffer after 1 minute, so terminate
                    break;
                }

                // succeeded in getting object from buffer, write it to file
                //copy the code from SortTester line 54-63
            
                fw.write(readingObj.toString() + "\n"); // write to filewriter to out.txt, next line
                
            } while(true);

            fw.close();
        } catch (IOException e) {
            System.err.println("Error in Consumer writing to file, please retry program:\n" + e.getMessage());
        }
    }
    
}