/** Copyright @ Cisco Systems Inc.
 *  Created Mar 30, 2014
 */
package org.javapractice.divideandconquer;

/**
 * @author shusingh
 *
 */
public class SumOfEvenNumbers {

	
	public static int sumEvenNumbers(int[] arr){
		return sumEvenNumbersRecursive(arr, 0, arr.length - 1);
	}
	
	private static int sumEvenNumbersRecursive(int [] arr, int lo, int hi){
		
		if( lo >= hi){
			if((arr[lo]) % 2 ==0){
				return arr[lo];
			}else{
				return 0;
			}
		}
		
		int mid = (hi + lo) / 2;
		
		
		
		int x = sumEvenNumbersRecursive(arr, lo, mid);
		int y = sumEvenNumbersRecursive(arr, mid + 1, hi);
		int sum = x + y;
		
		System.out.println("Sum = "+sum);
		
		return sum;
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{2,3,6,8,10,1};
		System.out.println("Total sum of even number="+sumEvenNumbers(arr));

	}

}
