import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable{
      private final ArrayBlockingQueue<Reading> sharedLocation;
      private final String threadName;
      private final ReentrantLock lock;

      public Producer(String name, ArrayBlockingQueue sharedLocation, ReentrantLock producerLock) {
         this.threadName = name;
         this.sharedLocation = sharedLocation;
         this.lock = producerLock;
      }

      @Override
      public void run() {
        Reading readObj = null;
        boolean accessLock;
        int min = 1;
        int max = 4;
        int range = max - min + 1;
        
        do{
            accessLock = lock.tryLock();
            if(accessLock){
                for(int i = 0; i < 2000; i++) {
                    int j = (int)(Math.random() * range) + min; 
        
                    if(j == 1) {
                        readObj = Reading.createObject(Location.NE);
                    }else if(j == 2) {
                        readObj = Reading.createObject(Location.NW);
                    }else if(j == 3) {
                        readObj = Reading.createObject(Location.SE);
                    }else if(j == 4) {
                        readObj = Reading.createObject(Location.SW);
                    }
            
                    try{
                        System.out.printf("%s is creating Reading object %s and inserting into buffer%n", threadName, readObj.id);
                        sharedLocation.put(readObj);
                    }catch (InterruptedException ine) {
                        Thread.currentThread().interrupt();
                    }
                }
                lock.unlock();
            }
        }while(!accessLock);
        
        System.out.printf("%s done producing%nTerminating %s%n", threadName, threadName);
      }
}   
