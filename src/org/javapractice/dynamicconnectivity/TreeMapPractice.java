/** Copyright @ Cisco Systems Inc.
 *  Created Jan 31, 2014
 */
package org.javapractice.dynamicconnectivity;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author shusingh
 *
 */
public class TreeMapPractice {
	
	
	public static void main(String[] args){
		
		Map<Integer,String> myMap = new TreeMap<Integer, String>();
		myMap.put(1321, "value");
		myMap.put(121, "value");
		myMap.put(231, "value");
		myMap.put(321, "value");
		
		for(Map.Entry<Integer, String> entry : myMap.entrySet()){
			System.out.println(entry.getKey());
		}
		
		
		
	}
	
	
	
	
	

}
