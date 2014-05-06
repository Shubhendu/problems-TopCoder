/** Copyright @ Cisco Systems Inc.
 *  Created Mar 29, 2014
 */
package org.javapractice.divideandconquer;

/**
 * @author shusingh
 *
 */
public class PowerUsingDivideAndConquer {
	
	public static int power(int x,int n){
		int temp;
		
		
		if (n == 0)
			return 1;
		
		temp = power(x,n/2);
		
		if (n % 2 == 0)
			return temp * temp;
		else
			return x * temp * temp;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(PowerUsingDivideAndConquer.power(2, 5));

	}

}
