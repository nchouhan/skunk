package producer.consumer.thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerPattern {
static Monitor monitor;

	public ProducerConsumerPattern(int maxsize){
	     //Creating shared object
//	     BlockingQueue sharedQueue = new LinkedBlockingQueue();
	    	monitor = new Monitor(maxsize);
	     //Creating Producer and Consumer Thread
	     new Producer().start();
	     new Consumer().start();
	     new Producer().start();
	     new Consumer().start();

	}
    public static void main(String args[]){
    	
    	ProducerConsumerPattern pcp = new ProducerConsumerPattern(5);
    }
    
    class Producer extends Thread {

        

       

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
    class Consumer extends Thread{

//      private final BlockingQueue sharedQueue;
  	
    
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
  class Monitor {
    	int n;
    	int maxsize;
    	public Monitor(int maxSize) {
    		// TODO Auto-generated constructor stub
    		n = 0;
    		maxsize = maxSize;
    	}
    	synchronized void insert() throws InterruptedException{
    		if (n >= maxsize)
    			wait();
    		System.out.println("Inserted"+n++);
    		if (n==1)
    			notifyAll();
    	}
    	synchronized void remove() throws InterruptedException{
    		if (n <= 0)
    			wait();
    		System.out.println("Removed"+n--);
    		if (n == maxsize -1 )
    			notifyAll();
    	}

    }
 
}


