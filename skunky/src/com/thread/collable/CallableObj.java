package com.thread.collable;

import java.util.concurrent.Callable;

public class CallableObj implements Callable<Integer> {
	int j = 0;
	public CallableObj() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i< 10000; i++) {
			j++;
		}
		System.out.println("Inside the thread "+j);
		return j;
	}

}
