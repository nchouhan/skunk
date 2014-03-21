package com.nc.tambola.util;

import java.util.Random;
import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		int[][] aTambolaNumbers = new int[10][10];
		Random aGenerator = new Random();
		int aGameNumber = 0;
		Scanner in = new Scanner(System.in);
		int aRowNum = 0;
		int aColNum = 0;
		for (int aGamePoint = 0; aGamePoint < 90;) {
			aGameNumber = aGenerator.nextInt(90);
			aRowNum = aGameNumber / 10;
			aColNum = aGameNumber % 10;
			if (aGameNumber != 0) {
				if (aTambolaNumbers[aRowNum][aColNum] == aGameNumber) {

				} else {
					aTambolaNumbers[aRowNum][aColNum] = aGameNumber;
					System.out.println("GameNumber:" + aGameNumber + ":Row:"
							+ aRowNum + ":Column:" + aColNum);
					aGamePoint++;
					printTambola(aTambolaNumbers);
					System.out
							.println("Press enter to next  Tambola Magic Number");
					in.nextLine();
				}
			}
		}
		// printTambola();
		// System.out.println(13/10);
	}

	public static void printTambola(int[][] iTambolaMatrix) {
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 10; column++) {
				if (iTambolaMatrix[row][column] / 10 == 0) {
					System.out.print((iTambolaMatrix[row][column] == 0 ? "X" : iTambolaMatrix[row][column]) + "   |  ");

				} else {
					System.out.print(iTambolaMatrix[row][column] + "  |  ");
				}
			}

			System.out
					.println("\n--------------------------------------------------------------------");
		}
	}
}
