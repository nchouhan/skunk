package producer.consumer.thread;

public class Monitor {
	int n;
	int maxsize;
	public Monitor(int maxSize) {
		// TODO Auto-generated constructor stub
		n = 0;
		maxsize = maxSize;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	synchronized void insert() throws InterruptedException{
		if (n == maxsize)
			wait();
		System.out.println("Inserted"+n++);
		if (n==1)
			notifyAll();
	}
	synchronized void remove() throws InterruptedException{
		if (n == 0)
			wait();
		System.out.println("Removed"+n--);
		if (n == maxsize -1 )
			notifyAll();
	}

}
