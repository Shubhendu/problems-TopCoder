package org.javapractice.greedy;

import java.util.Random;

public class TIPSharing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] tipsArr = new int[] { 1, 10, 1, 5, 5, 10, 10, 5, 10, 5 };

		Random random = new Random();


		for (int i = 1; i < tipsArr.length; i++) {			

			int j = random.nextInt(i);
			int temp = tipsArr[i];
			tipsArr[i] = tipsArr[j];
			tipsArr[j] = temp;

		}

		for (int i = 0; i < tipsArr.length; i++) {
			System.out.print("\t "+tipsArr[i]);
		}

		int l = 0;
		int r = tipsArr.length-1;
		int b = 0;
		int a = 0;

		
		System.out.println("\nShare distribution");
		while(l < r){
			if(tipsArr[r-1] >= tipsArr[l+1]){
				if((tipsArr[r] - tipsArr[l]) >= (tipsArr[r-1] - tipsArr[l+1]) ){
					a += tipsArr[r];
					System.out.println("Alice took share from right at the index: "+(r--));
				}else{
					a += tipsArr[l];
					System.out.println("Alice took share from left at the index: "+(l++));
				}
			}else{
				if((tipsArr[r] - tipsArr[l]) <= (tipsArr[r-1] - tipsArr[l+1]) ){
					a += tipsArr[r];
					System.out.println("Alice took share from right at the index: "+(r--));
				}else{
					a += tipsArr[l];
					System.out.println("Alice took share from left at the index: "+(l++));
				}

			}
			
			if(tipsArr[r] >= tipsArr[l]){
				b += tipsArr[r];
				System.out.println("Bob took share from right at the index: "+(r--));
			}else{
				b += tipsArr[l];
				System.out.println("Bob took share from left at the index: "+(l++));
			}

		}
		System.out.println("\n Alice share: "+a);
		System.out.println("\n Bob share: "+b);

	}

}
