import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
 
public class Buffer {
    private ArrayBlockingQueue<Reading> queue = new ArrayBlockingQueue<>(100);

    public void add(Reading reading) {
        try {
            queue.put(reading);  //.put will wait for avaliable space first then add the queue 
            //When beginning have 100 space, 
        } catch(InterruptedException e) {
            System.err.println("Failed to put reading object into queue due to Interrupted exception: \n" + e.getMessage());
        }
    }

    public Reading get() {  //get the queue from poll
        try {
            return queue.poll(1, TimeUnit.MINUTES);
        } catch(InterruptedException e) {
            return null;
        }
    }
}