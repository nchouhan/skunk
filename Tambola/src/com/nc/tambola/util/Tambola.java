package com.nc.tambola.util;

import java.util.Random;

public class Tambola {
	public static void main(String[] args) {
		// getRandom(30);
		for (int aNumTickets = 0; aNumTickets < 30; aNumTickets++) {
			System.out.println("============================Ticket-"+aNumTickets+"=======================");
//			System.out.println("==============================================================================================");
			int[][] aTambolaMatrix = getMatrix();
			printMatrix(aTambolaMatrix);
		}
	}

	public static int getRandom(int base) {
		int baseRandom = 0;
		Random rNum = new Random();
		for (int i = 0; i < 10;) {
			baseRandom = rNum.nextInt(100);
			baseRandom = (baseRandom == 0) ? baseRandom + 1 : baseRandom;
			if (baseRandom < base && baseRandom >= (base - 10)) {
				// System.out.println(baseRandom);
				i++;
			}
		}
		return baseRandom;
	}

	public static int[][] getMatrix() {
		int[][] aMatrix = new int[3][9];
		for (int row = 0; row < 3; row++) {
			// System.out.println();
			for (int columnfiled = 0; columnfiled < 5;) {
				int columnNumber = getRandom(10);

				if (columnNumber <= 9 && aMatrix[row][columnNumber - 1] == 0) {
					int columnValue = getRandom(columnNumber * 10);
					boolean alreadyUsed = false;
					for (int checkrow = 0; checkrow < 3; checkrow++) {
						if (aMatrix[checkrow][columnNumber - 1] == columnValue) {
							alreadyUsed = true;
						}
					}
					if (!alreadyUsed) {
						aMatrix[row][columnNumber - 1] = columnValue;
						columnfiled++;
					}
				}
			}
		}
		return aMatrix;
	}

	public static void printMatrix(int[][] iMatrix) {
		for (int row = 0; row < 3; row++) {
//			System.out.println("---------------------------------------------------------");
			for (int column = 0; column < 9; column++) {
				if (iMatrix[row][column] == 0 && column != 0) {
					System.out.print(iMatrix[row][column] + "   |  ");
				} else {
					System.out.print(iMatrix[row][column] + "  |  ");
				}
			}
			System.out.println("\n------------------------------------------------------------");

		}
		System.out.println();
	}
}
