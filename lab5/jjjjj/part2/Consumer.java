import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Consumer implements Runnable {
      private final ArrayBlockingQueue<Reading> sharedLocation;
      private final String threadName;
      private final ReentrantLock lock;
      
      public Consumer(String name, ArrayBlockingQueue sharedLocation, ReentrantLock consumerLock) {
          this.threadName = name;
          this.sharedLocation = sharedLocation;
          this.lock = consumerLock;
      }

      @Override
      public void run() {
        try{
          FileWriter fw = new FileWriter(threadName + ".txt");
          BufferedWriter bw = new BufferedWriter(fw);
          boolean accessLock;
          
          do{
              accessLock = lock.tryLock();
              if(accessLock){
                Reading readObj = sharedLocation.poll(1, TimeUnit.MINUTES);
                if(readObj == null){
                    System.out.printf("%s has waited over a minute to remove an object from the buffer%nTerminating %s%n", threadName, threadName);
                    return;
                }else{
                    System.out.printf("%s is taking out Reading object %s from buffer and writing it to file%n", threadName, readObj.id);
                    bw.write(readObj.toString());
                    bw.newLine();
                    lock.unlock();
                    Thread.sleep(100);
                }
              }
          }while(!accessLock || sharedLocation.size() > 0);
          
          bw.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (InterruptedException ine) {
            Thread.currentThread().interrupt();
        }

         System.out.printf("%s done reading and writing to file%nTerminating %s%n", threadName, threadName);
      }
}
