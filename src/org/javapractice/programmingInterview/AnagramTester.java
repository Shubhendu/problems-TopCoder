/** Copyright @ Cisco Systems Inc.
 *  Created Apr 28, 2014
 */
package org.javapractice.programmingInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author shusingh
 *
 */
public class AnagramTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string1:");
		String str1 = scanner.next();
		str1= str1.toLowerCase();
		System.out.println("Enter the string2:");
		String str2 = scanner.next();
		str2 = str2.toLowerCase();
				
		Map<Character, Integer> strMap = new HashMap<Character, Integer>();

		int count = 0;

		for( char c : str1.toCharArray()){
			Character key = (Character) c;
			if(strMap.get(key) == null){
				count = 0;
			}else{
				count = strMap.get(key);
			}
			strMap.put(key, ++count);			
		}

		boolean isAnagram = true;
		for(char c: str2.toCharArray()){
			Character key = (Character) c;

			if(strMap.get(key) == null){
				System.out.println("Strings are not anagram");
				isAnagram = false;
				break;
			}else{
				strMap.put(key, strMap.get(key) - 1);
			}			
		}

		if(isAnagram){
			for(Map.Entry<Character, Integer> entry: strMap.entrySet()){
				if(entry.getValue() != 0){
					System.out.println("Strings are not anagrams");
					isAnagram = false;
					break;
				}
			}
		}
		if(isAnagram){
			System.out.println("Strings are anagrams " + str1 +" : "+str2);
		}

	}

}
