public class ProducerTester {

    public static void main(String[] args) throws InterruptedException {
        // create a Buffer
        Buffer buffer = new Buffer();
        
        // make 5 Producer threads
        Thread producerThread1 = new Thread(new Producer(buffer));
        Thread producerThread2 = new Thread(new Producer(buffer));
        Thread producerThread3 = new Thread(new Producer(buffer));
        Thread producerThread4 = new Thread(new Producer(buffer));
        Thread producerThread5 = new Thread(new Producer(buffer));

        // make 3 Consumer threads
        Thread consumerThread1 = new Thread(new Consumer("consumer1", buffer));  //" " is the file name  
        Thread consumerThread2 = new Thread(new Consumer("consumer2", buffer));
        Thread consumerThread3 = new Thread(new Consumer("consumer3", buffer));

        // start all the threads by typing  .start();
        producerThread1.start();
        producerThread2.start();
        producerThread3.start();
        producerThread4.start();
        producerThread5.start();
        
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

        // wait for all threads to finish by calling join()
        producerThread1.join();
        producerThread2.join();
        producerThread3.join();
        producerThread4.join();
        producerThread5.join();

        consumerThread1.join();
        consumerThread2.join();
        consumerThread3.join();
    }
}