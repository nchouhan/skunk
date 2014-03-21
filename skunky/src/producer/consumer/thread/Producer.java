package producer.consumer.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    static Monitor monitor;

    public Producer(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                
                monitor.insert();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}


