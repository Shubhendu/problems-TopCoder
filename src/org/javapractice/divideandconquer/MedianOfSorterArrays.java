/** Copyright @ Cisco Systems Inc.
 *  Created Mar 29, 2014
 */
package org.javapractice.divideandconquer;

/**
 * @author shusingh
 * 
 */
public class MedianOfSorterArrays {

	public static double findMedian(int[] arr1, int[] arr2) {

		return findMedianRecurs(arr1, arr2, 0, arr1.length - 1, 0,
				arr1.length - 1);
	}

	private static double findMedianRecurs(int[] arr1, int[] arr2, int arr1Lo,
			int arr1Hi, int arr2Lo, int arr2Hi) {

		if (arr1.length == 2) {
			int x, y;

			if (arr1[0] < arr2[0]) {
				x = arr2[0];
			} else {
				x = arr1[0];
			}

			if (arr1[1] < arr2[1]) {
				y = arr1[1];
			} else {
				y = arr2[1];
			}

			return (x + y) / 2;
		}

		double arr1Median, arr2Median;
		int i = (arr1Hi - arr1Lo) / 2;
		int j = (arr2Hi - arr2Lo) / 2;

		if ((arr1Hi - arr1Lo) % 2 == 0) {
			arr1Median = arr1[i];

		} else {
			arr1Median = arr1[i] + arr1[i + 1];
		}

		if ((arr2Hi - arr2Lo) % 2 == 0) {
			arr2Median = arr2[j];
		} else {
			arr2Median = arr2[j] + arr2[j + 1];
		}

		if (arr1Median == arr2Median)
			return arr1Median;

		int[] auxArr1 = new int[i + 1];
		int[] auxArr2 = new int[j + 1];

		int count =0;
		
		if (arr1Median < arr2Median) {
			
			count = i;
			for (int k = 0; k <= (arr1Hi - i); k++) {
				
				auxArr1[k] = arr1[count++];
			}

			count = arr2Lo;
			for (int k = 0; k <= (j - arr2Lo); k++) {
				auxArr2[k] = arr2[count++];
			}

			return findMedianRecurs(auxArr1, auxArr2, i, arr1Hi, arr2Lo, j);
		} else {
			count = arr1Lo;
			for (int k = 0; k <= (i - arr1Lo); k++) {
				auxArr1[k] = arr1[count++];
			}

			count = j;
			for (int k = 0; k <= (arr2Hi - j); k++) {
				auxArr2[k] = arr2[count++];
			}

			return findMedianRecurs(auxArr1, auxArr2, arr1Lo, i, j, arr2Hi);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 12, 15, 26, 38 };
		int[] arr2 = new int[] { 2, 13, 17, 30, 45 };

		System.out.println(MedianOfSorterArrays.findMedian(arr1, arr2));

	}

}
