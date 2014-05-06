package org.javapractice.divideandconquer;

public class TestDAndC {

	public int largestIncreasingSubArraySum(int[] arr) {
		return largestIncrSubArrSumRecursive(arr, 0, arr.length - 1);
	}

	private int largestIncrSubArrSumRecursive(int[] arr, int lo, int hi) {

		if (hi <= lo)
			return arr[lo];

		int mid = (hi + lo) / 2;

		int x = largestIncrSubArrSumRecursive(arr, lo, mid);
		int y = largestIncrSubArrSumRecursive(arr, mid + 1, hi);
		int z = largestCrossArrSumRecursive(arr, lo, mid, hi);

		return (max(x, y, z));

	}

	private int largestCrossArrSumRecursive(int[] arr, int lo, int mid, int hi) {

		int sum = 0;
		int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;

		for (int i = mid; i >= lo; i--) {
			sum += arr[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}

		sum = 0;
		for (int i = mid + 1; i <= hi; i++) {
			sum += arr[i];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}

		return leftSum + rightSum;

	}

	private int max(int x, int y) {
		if (x > y)
			return x;
		else
			return y;
	}

	private int max(int x, int y, int z) {

		return (max(max(x, y), z));

	}

	public static void main(String[] args) {
		int[] arr = new int[] { -2, -5, 6, -2, -3, 1, 5, -6 };
		
		TestDAndC test = new TestDAndC();
		System.out.println(test.largestIncreasingSubArraySum(arr));
		

	}

}
