package com.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/*PROBLEM STATEMENT : Build algo to find intersection list of all supplied list of Integers, show the duplicate if intersection is found across*/
/*Sample 
 * A1 = 1, 4 ,7, 2, 8 
 * A2 = 1, 5 ,2, 2, 7 
 * A3 = 1, 5 ,7, 2, 2 
 * A4 = 1, 5 ,7, 2, 8 
 * Intersection = 1,7,2*/
/*Algorithm
 * Iterate Through all the list of element and sort them using (Merge sort or Quick sort)
 * 
 * findIntersection(){
 * 		var intersectionList = dataList.get(0);
 * 		var size = dataList.size();
 * 		for (listElement : datList) {
 * 			intersectionList = findInter(intersectionList, listElement){
 * 		}
 * 	-- intersectionList is final list with common element in all list
 * }
 * 
 * --List provided are ordered (This will help in stopping further compare if needed) 
 * List findInter(listOne, listTwo){
 * 		var tempList;
 * 		var foundCounter = 0;
 * 		for (elementOne : listOne) {
 * 			for (counterTwo = foundCounter ; counterTwo< listTwo.size; counterTwo ++) {
 * 				if (elementTwo > elementOne) {
 * 					break; --Stop compare as no way finding element further
 * 				}
 * 			 
 * 				if (elementTwo == elementOne) {
 * 				tempList = elementTwo;
 * 				foundCounter = counterTwo;		--This will start compare from next element next compare cycle 
 * 				}
 * 			}
 *
 * 		}
 * }
 */
public class ListIntersection {
	private static List<List<Integer>> aDataList;
	private static List<Integer> aInterSectionList;
	private static int maximum = 1000;
	private static int metricHeight = 2;
	private static int metricLength = 100;
	public static void main(String[] args) {
		buildData();
		System.out.println("PRINT DATA BEFORE SORTING");
		printAllData();
		aInterSectionList = findIntersection(aDataList);
		printList(aInterSectionList);
	}
	/*Time Complexity
	 * O(f(n)) =  O(m(nlog(n))) + O(m*n)
	 * O(f(n)) = O(m*n (log(n) + 1))
	 * O(f(n)) =~ C * O(m*n log(n))
	*/
	public static List<Integer> findIntersection(List<List<Integer>> l) {
		int size = l.size();
		List<Integer> listOne;
		List<Integer> listTwo;

		// Sort the list available complexity O(m(nlog(n)))
		for (List<Integer> aList : l) {
			Collections.sort(aList);
		}
		System.out.println("PRINT DATA AFTER SORTING");
		printAllData();
		
		listOne = l.get(0);
		
		//Complexity O(m)
		for (int i = 1; i < size; i++) {
			listTwo = l.get(i);
			listOne = findInter(listOne, listTwo);//Comlexity O(n)
		}
		System.out.println("INTERSECTION LIST DATA");
		printList(listOne);
		return listOne;
	}
	
	private static List<Integer> findInter(List<Integer> listOne,
			List<Integer> listTwo) {
		List<Integer> finalList = new ArrayList<Integer>();
		// boolean matchfound = false;
		int placecounter = 0;
		//COMPLEXITY : max n as will not need to have comparison more than n times overall as place counter will avoid the already compared values
		for (int elementOne : listOne) {			
			int size = listTwo.size();
			for (int i = placecounter; i < size; i++) {
				if (elementOne < listTwo.get(i)) {
					break;
				}
				if (elementOne == listTwo.get(i)) {
					finalList.add(elementOne);
					placecounter = i+1;
					// Keep the count where it was found and do the next compare
					// from next elements
					// Remove the element one found
					// listOne.remove
					// matchfound = true;
					break;

				}
			}
		}
		return finalList;
	}
	
	
	/*Utility methods just used to create test data set and print results
	 * 
	 * */
	private static void buildData(){
		aDataList = new ArrayList<List<Integer>>();
		List<Integer> aTempData;
		for (int i = 0; i< metricHeight; i++){
			aTempData = new ArrayList<Integer>();
			for (int j = 0; j< metricLength; j++){
				aTempData.add(getRandom());
			}
			aDataList.add(aTempData);
		}
		 
	}
	
	private static void printAllData(){
		List<Integer> aTempData = new ArrayList<Integer>();
		for (int i = 0; i< metricHeight; i++){
			System.out.print("Row : "+i+    ":		");
			aTempData =aDataList.get(i);
			printList(aTempData);
			System.out.println("");
		}
		 
	}
	
	
	private static void printList(List<Integer> aTempData){
		for (Integer aData : aTempData){
			System.out.print(aData+",");
		}
	}
	
	private static Integer getRandom(){
		Random rn = new Random();
		int i = rn.nextInt(maximum);
		return  i;
	}
}
