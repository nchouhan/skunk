package com.thread.forkjoin;

import java.util.concurrent.Callable;

public class ThreadJob implements Runnable{
	int result = 0;
	public ThreadJob() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <100; i ++) {
			result++;
		}
		System.out.println(result);
	}

//	@Override
//	public Integer call() throws Exception {
//		// TODO Auto-generated method stub
//		
//		for (int i = 0; i <100; i ++) {
//			result++;
//		}
//		return result;
//	}

}
