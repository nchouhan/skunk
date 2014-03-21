package producer.consumer.thread;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable{

//    private final BlockingQueue sharedQueue;
	 public static Monitor monitor;

    public Consumer (Monitor iMonitor) {
        this.monitor = iMonitor;
    }
  
    @Override
    public void run() {
        while(true){
            try {
                monitor.remove();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
  
}


