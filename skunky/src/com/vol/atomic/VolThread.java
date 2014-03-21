package com.vol.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class VolThread implements Runnable {
	AtomicInteger  i = new AtomicInteger(0);
	volatile int k = 0;
	public VolThread() {
		// TODO Auto-generated constructor stub
	}
	//If variable is volatile its not assured that value of variable is modified atomically hence at the end as well may see value not correct
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int j =0; j< 1000000; j++) {
//			i.addAndGet(1);
			k++;
		}
		System.out.println("Current Thread before Exit "+Thread.currentThread().getName() +"Where count is "+k);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
