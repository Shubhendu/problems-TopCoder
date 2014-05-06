/** Copyright @ Cisco Systems Inc.
 *  Created May 6, 2014
 */
package org.javapractice.programmingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shubhendu Singh
 * 
 */
public class MergeSort {

	private static int comparisonCount = 0;
	private static Integer[] inputArr;

	public static int howManyComparisons(int[] numbers){
		
		//reset counter everytime this function is called
		initialize(numbers.length);


		for(int i =0;i<numbers.length;i++){
			inputArr[i] = Integer.valueOf(numbers[i]);
		}

		List<Integer> a = (List<Integer>) Arrays.asList(inputArr);
		mergeSort(a);
		
		System.out.println("\nSorted array\n");
		for(int i =0;i<numbers.length;i++){
			System.out.print(inputArr[i]+"\t");
		}

		return comparisonCount;
	}

	private static void initialize(int arrSize) {
		comparisonCount = 0;
		inputArr = new Integer[arrSize];
		
	}

	private static List<Integer> mergeSort(List<Integer> a) {

		int listSize = a.size();
		if (listSize <= 1)
			return a;

		List<Integer> b = null;
		List<Integer> c = null;

		b = a.subList(0, listSize / 2 );
		c = a.subList(listSize / 2, listSize);

		List<Integer> sb = mergeSort(b);
		List<Integer> sc = mergeSort(c);

		return merge(sb, sc);
	}

	private static List<Integer> merge(List<Integer> b, List<Integer> c) {

		List<Integer> a = new ArrayList<Integer>();
		int countB = 0;
		int countC = 0;

		int bSize = b.size();
		int cSize = c.size();
		
		
		while ((countB < bSize) || (countC < cSize)) {
			if ((countB >= bSize) && (countC < cSize)) {
				a.add(c.get(countC++));
			} else if ((countB < bSize) && (countC >= cSize)) {
				a.add(b.get(countB++));
			} else if ((b.get(countB).compareTo(c.get(countC)) < 0)) {
				a.add(b.get(countB++));
				comparisonCount++;
			} else if ((b.get(countB).compareTo(c.get(countC)) > 0)) {
				a.add(c.get(countC++));
				comparisonCount++;
			} else {
				a.add(b.get(countB++));
				a.add(c.get(countC++));
				comparisonCount++;
			}
		}

		return a;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Number of comparisons involved: "+MergeSort.howManyComparisons(new int[]{1, 2, 3, 4}));
		

		System.out.println("Number of comparisons involved: "+MergeSort.howManyComparisons(new int[]{2, 3, 2}));
		
		System.out.println("Number of comparisons involved: "+MergeSort.howManyComparisons(new int[]{-2000000000,2000000000,0,0,0,-2000000000,2000000000,0,0,0}));
		
		System.out.println("Number of comparisons involved: "+MergeSort.howManyComparisons(new int[]{-17}));
		System.out.println("Number of comparisons involved: "+MergeSort.howManyComparisons(new int[]{}));

	}

}
