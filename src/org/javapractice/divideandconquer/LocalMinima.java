/** Copyright @ Cisco Systems Inc.
 *  Created Apr 28, 2014
 */
package org.javapractice.divideandconquer;

/**
 * @author shusingh
 * 
 */
public class LocalMinima {

	public int findLocalMinima(int[] arr) {
		return findLocalMinima(arr, 0, arr.length - 1);
	}

	private int findLocalMinima(int[] arr, int lo, int hi){
	if(hi<=lo) return -1;

	int mid = (hi+lo)/2;

	if(arr[mid - 1] > arr[mid] && arr[mid] < arr[mid+1])
		return arr[mid];
	
	
	if(arr[mid] < arr[mid+1])
		return findLocalMinima(arr, lo, mid + 1);
	else 
		return findLocalMinima(arr, mid, hi);
	
//	else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid+1]) 
//		return findLocalMinima(arr, lo,mid);
//	else if(arr[mid - 1 ] > arr[mid] && arr[mid] > arr[mid + 1])
//		return findLocalMinima(arr, mid,hi);
//	else 
//		return findLocalMinima(arr,mid,hi);



	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{2,10,30,40,10,8,11};

		LocalMinima localMinima = new LocalMinima();
		System.out.println(localMinima.findLocalMinima(arr));
		
	}

}
