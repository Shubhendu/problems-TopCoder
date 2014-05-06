package org.javapractice.dynamicprogramming;

import java.util.Random;

public class LargestIncreasingSubsequence {

	public int longestIncreasingSub(int[] arr) {
		int longestSSCount = 0;
		int currIndex = 0;
		int n = arr.length;
		int[] lis = new int[n];
		int[] path = new int[n];

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			path[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && (lis[j] + 1 > lis[i])){
					lis[i] = lis[j] + 1;
					path[i] = j;					
				}				
			}
			
			if(lis[i] > longestSSCount) {
				longestSSCount = lis[i];
				currIndex = i;
				
			}
		}
		int prevIndex = path[currIndex];
		while(prevIndex >= 0){
			System.out.print(arr[currIndex]+"\t");
			prevIndex = path[currIndex];
			currIndex = prevIndex;
		}
		
		return longestSSCount;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[10];
		Random random = new Random();
		
		for(int i=0;i<10;i++){
			arr[i] = random.nextInt((i*10) +15);
			System.out.print(arr[i]+"\t");
		}
		System.out.println("\nLongest increasing subsequence");

		LargestIncreasingSubsequence lis = new LargestIncreasingSubsequence();
		System.out.println("\nLength of LIS is "+lis.longestIncreasingSub(arr));

	}

}
