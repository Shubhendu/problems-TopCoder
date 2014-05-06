/** Copyright @ Cisco Systems Inc.
 *  Created Jan 28, 2014
 */
package org.javapractice.dynamicconnectivity;

import java.util.Scanner;

/**
 * @author shusingh
 *
 */
public class BitManipulation {
	
	public static void main(String[] args) throws Exception{
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter input:");
//		int n = scanner.nextInt();
//		
//		if(n<0){
//			throw new Exception("No factorial can be computed for negative number");
//		}
//		int count = 0;
//		for (int i = 5; i <= n; i += 5) {
//			count++;
//		}
//		System.out.println("Number of zeroes in the factorial= "+count);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number");
		int x = scanner.nextInt();
		int radix = 2;
//		System.out.println("x: "+Integer.toBinaryString(x) + ": Number is: " +Integer.parseInt(Integer.toBinaryString(x), radix));
//		System.out.println("~x: "+Integer.toBinaryString(~x)+ ": Number is: " +Integer.parseInt(Integer.toBinaryString(~x), radix));
//		System.out.println("x>>1: "+Integer.toBinaryString(x>>1) + ": Number is: " +Integer.parseInt(Integer.toBinaryString(x>>1), radix));
//		System.out.println("x>>>1: "+Integer.toBinaryString(x>>>1) + ": Number is: " +Integer.parseInt(Integer.toBinaryString(x>>>1), radix));
//		System.out.println("x<<1 "+Integer.toBinaryString(x<<1) + ": Number is: " +Integer.parseInt(Integer.toBinaryString(x<<1), radix));
		
		
		System.out.println("x: "+Integer.toBinaryString(x) );
		
		System.out.println("Hex x: "+Integer.toHexString(x) );
		
		System.out.println("Oct x: "+Integer.toOctalString(x) );
		
		
		System.out.println("x >>>2: "+Integer.toBinaryString(x >>> 2));
		System.out.println("~x: "+Integer.toBinaryString(~x));
		System.out.println("x>>1: "+Integer.toBinaryString(x>>1) );
		
		System.out.println("x<<1 "+Integer.toBinaryString(x<<1) );
		
	}

}
