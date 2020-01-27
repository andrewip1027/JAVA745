import java.util.concurrent.*;

public class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer = buffer;
    }
    
	@Override
	public void run() { 
        // Create 2000 Reading objects and add them to Buffer
        for(int i = 0; i < 2000; i++){
            buffer.add(Reading.createObject());
        }
	}
    
}