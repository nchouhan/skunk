package com.algos;

import java.util.Arrays;


public class VictoryVector {

	int[] array = null;

	VictoryVector(int[] arr) {
		array = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i] = arr[i];
		}
	}

	@Override
	public String toString() {
		return "VictoryVector [array=" + Arrays.toString(array) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VictoryVector other = (VictoryVector) obj;
		if (!Arrays.equals(array, other.array))
			return false;
		return true;
	}

}
