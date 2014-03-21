package com.vol.atomic;

public class VolatileTest {

	public VolatileTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1 = System.currentTimeMillis();
		VolThread vt = new VolThread();
		Thread v1 = new Thread(vt, "One");
		Thread v2 = new Thread(vt, "Two");
		Thread v3 = new Thread(vt, "Three");
		v1.start();
		v2.start();
		v3.start();
		long t2 = System.currentTimeMillis();
		System.out.println("Time taken "+ (t2-t1));
	}

}
