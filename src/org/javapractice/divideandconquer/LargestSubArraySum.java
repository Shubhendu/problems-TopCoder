package org.javapractice.divideandconquer;

public class LargestSubArraySum {

	public static int largestSubArrSum(int [] arr){
		return largestSubArrSumRecursive(arr,0,arr.length -1);
	}

	private static int largestSubArrSumRecursive(int [] arr,int lo,int hi){

		if(lo == hi)
			return arr[lo];

		int mid = (lo + hi) / 2;
		int x = largestSubArrSumRecursive(arr, lo, mid);
		int y = largestSubArrSumRecursive(arr, mid + 1, hi);
		int z = largestCrossArraySum(arr, lo, mid, hi);

		return (maxOfThree(x, y, z));

	}

	private static int largestCrossArraySum(int[] arr, int lo,int mid, int hi){
		int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;

		for (int i = mid; i >= lo; i--) {
			sum += arr[i];
			if(sum > leftSum)
				leftSum = sum;
		}
		sum = 0;
		for (int j = mid + 1; j <= hi; j++) {
			sum += arr[j];
			if (sum > rightSum)
				rightSum = sum;
		}
		return leftSum + rightSum;
	}


	private static int max(int a,int b){
		return (a>b) ?a:b;
	}

	private static int maxOfThree(int a, int b, int c){
		return max(max(a,b),c);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
				int[] arr = new int[] { -2, -5, 6, -2, -3, 1, 5, -6 };
//		int[] arr = new int[] { 1, -7, 10, -11, 5, 7, -10, 15,5 };
		
//		int[] arr = new int[] { -1,-1,-1,-1,-1};


		System.out.println(LargestSubArraySum.largestSubArrSum(arr));
				

	}

}
