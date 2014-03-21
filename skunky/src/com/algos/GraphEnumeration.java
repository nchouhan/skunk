package com.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphEnumeration {
	
	public static void main(String[] args) {
		int playerCount = 5;
		int[][][] matchScoreCombination = getCombination(playerCount);
		int[] playerScore = new int[playerCount];
		List<VictoryVector> list = new ArrayList<VictoryVector>();
		getVictoryScore(matchScoreCombination, playerScore, 0, list);
		System.out.println("vector count : " + list.size());
	}

	private static int[][][] getCombination(int n) {
		int[][][] retArr = new int[(n * (n - 1)) / 2][2][2];
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				retArr[count][0][0] = i;
				retArr[count][0][1] = j;
				retArr[count][1][0] = j;
				retArr[count][1][1] = i;
				count++;
			}
		}
		System.out.println(count);
		return retArr;
	}

	private static void getVictoryScore(int[][][] matchScoreCombination,
			int[] playerScore, int currentIndex, List<VictoryVector> vectorList) {
		if (currentIndex == matchScoreCombination.length) {
			VictoryVector vicVec = new VictoryVector(playerScore);
			if (!vectorList.contains(vicVec)) {
				vectorList.add(vicVec);
				System.out.println(vicVec);
			}

			return;
		}
		int[][] matchScore = matchScoreCombination[currentIndex];
		playerScore[matchScore[0][1]]++;
		int nextIndex = currentIndex + 1;
		getVictoryScore(matchScoreCombination, playerScore, nextIndex,
				vectorList);
		playerScore[matchScore[0][1]]--;
		playerScore[matchScore[1][1]]++;
		getVictoryScore(matchScoreCombination, playerScore, nextIndex,
				vectorList);
		playerScore[matchScore[1][1]]--;
	}

	
	public GraphEnumeration() {
		// TODO Auto-generated constructor stub
	}

	

}
