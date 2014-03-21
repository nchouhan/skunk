package com.thread.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MaxFinder extends RecursiveTask<Integer> {
	// Instance variable
	int result;
	int start;
	int end;
	final static int squential_threashold = 10;//When to compute serial 
	int[] data;

	public MaxFinder() {
		// TODO Auto-generated constructor stub
	}

	public MaxFinder(int[] data) {
		super();
		this.data = data;
	}

	public MaxFinder(int start, int end, int[] data) {
		super();
		this.start = start;
		this.end = end;
		this.data = data;
	}

	/**
	 * Method to find max in small size array serially
	 * 
	 * @return
	 */
	public Integer getMax() {
		int max = 0;
		for (int i = start; i < end; i++) {
			if (max < data[i]) {
				max = data[i];
			}
		}
		return max;
	}

	// Overriden method from Recursive task where parallel task is build and
	// executed
	@Override
	protected Integer compute() {
		int size = end - start;
		if (size <= squential_threashold) {
			return getMax();
		}
		int root = size / 2;
		MaxFinder left = new MaxFinder(start, start + root, data);
		left.fork();// to be forked and executed
		MaxFinder right = new MaxFinder(start + root, end, data);
		// TODO Auto-generated method stub
		return Math.max(right.compute(), left.join());// compute will wait till
														// left is done
	}

	/**
	 * To create dummy data
	 * 
	 * @return
	 */
	private static int[] createData() {
		System.out.println();
		int[] dummydata = new int[1000000];

		Random random = new Random();
		for (int i = 0; i < 1000000; i++) {
			dummydata[i] = random.nextInt(1000);
		}
		return dummydata;
	}

	public static void main(String[] args) {

		MaxFinder mf = new MaxFinder(0, 999, createData());
		long startTime = System.currentTimeMillis();
		ForkJoinPool fjp = new ForkJoinPool(10);
		System.out.println(fjp.invoke(mf));// Result Max will be printed
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken" + (endTime - startTime));
	}
}
