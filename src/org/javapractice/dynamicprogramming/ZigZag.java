/** Copyright @ Cisco Systems Inc.
 *  Created Apr 27, 2014
 */
package org.javapractice.dynamicprogramming;

/**
 * @author shusingh
 * 
 */
public class ZigZag {

	public int zigZag(int[] arr) {
		int n = arr.length;
		int[][] z = new int[n][2];
		int maxZigZagCount = 0;

		for (int i = 0; i < n; i++) {
			z[i][0] = 1;
			z[i][1] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				
				if((arr[i] - arr[j]) > 0){
					z[i][0] = max(z[i][0] , (z[j][1] + 1));
				}else if ((arr[i] - arr[j] < 0)){
					z[i][1] = max(z[i][1] , z[j][0] + 1);
				}
			}
			
			maxZigZagCount = max(max(z[i][0],z[i][1]),maxZigZagCount);
			
		}

		return maxZigZagCount;
	}

	private int max(int x, int y) {
		if (x > y)
			return x;
		else
			return y;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = new int[]{3,17,18,4,16,29,15,33,19,22};

		ZigZag z = new ZigZag();
		System.out.println(z.zigZag(arr));
	}

}
