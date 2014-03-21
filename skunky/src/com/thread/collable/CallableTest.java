package com.thread.collable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public CallableTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallableObj co = new CallableObj();
		CallableObj co1 = new CallableObj();
		CallableObj co12 = new CallableObj();
		CallableObj co13 = new CallableObj();
		CallableObj co14 = new CallableObj();
		CallableObj co15 = new CallableObj();
		CallableObj co16 = new CallableObj();
		ExecutorService es = Executors.newFixedThreadPool(10);
		ExecutorService es1 = Executors.newFixedThreadPool(10);

		Future<Integer> f = es.submit(co);
		Future<Integer> f1 = es.submit(co1);
		Future<Integer> f2 = es.submit(co12);
		Future<Integer> f3 = es.submit(co13);
		Future<Integer> f4 = es.submit(co14);
		Future<Integer> f5 = es.submit(co15);
		Future<Integer> f6 = es.submit(co16);
		try {
		System.out.println(f.get().intValue());
		System.out.println(f1.get().intValue());
		System.out.println(f2.get().intValue());
		System.out.println(f3.get().intValue());
		System.out.println(f4.get().intValue());
		System.out.println(f5.get().intValue());
		System.out.println(f6.get().intValue());
		} catch (InterruptedException | ExecutionException ie) {
			ie.printStackTrace();
		}
		es.shutdown();
	}

}
