package com.paypal;

public class Thread1 extends Thread{

	public Thread1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	//start will be used when asynchronous execution is require whenever start is called will creat thread and call run
	// while calling run means executing synchronously in current thread not thread advantage is being used 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t1 = new Thread1();
		Thread thread = new Thread(t1);
		System.out.println("################################Run1");
		thread.start();
		System.out.println("************************************Run2");
		thread.start();
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Run over");
	}
	
	public void run() {
		for (int i =0; i <10; i ++){
			System.out.println(""+i);
		}
//		System.out.println("Thread1");
	}

}
