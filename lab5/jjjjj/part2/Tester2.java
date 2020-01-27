import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Tester {
   public static void main(String[] args) {
       ArrayBlockingQueue<Reading> buffer = new ArrayBlockingQueue<>(100);
       ReentrantLock consumerLock = new ReentrantLock();
       ReentrantLock producerLock = new ReentrantLock();
       Producer p1 = new Producer("Producer#1", buffer, producerLock);
       Producer p2 = new Producer("Producer#2", buffer, producerLock);
       Producer p3 = new Producer("Producer#3", buffer, producerLock);
       Producer p4 = new Producer("Producer#4", buffer, producerLock);
       Producer p5 = new Producer("Producer#5", buffer, producerLock);
       Consumer c1 = new Consumer("Consumer#1", buffer, consumerLock);
       Consumer c2 = new Consumer("Consumer#2", buffer, consumerLock);
       Consumer c3 = new Consumer("Consumer#3", buffer, consumerLock);
       
       try{
           ExecutorService e = Executors.newCachedThreadPool();
           e.execute(p1);
           e.execute(p2);
           e.execute(p3);
           e.execute(p4);
           e.execute(p5);
           e.execute(c1);
           e.execute(c2);
           e.execute(c3);
           e.shutdown();
           e.awaitTermination(1, TimeUnit.MINUTES);
       } catch (InterruptedException ine){
           Thread.currentThread().interrupt();
       }
   }
}