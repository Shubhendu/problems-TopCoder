package org.javapractice.programmingInterview;

import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shubhendu Singh
 * 
 */

public class CeyKaps {

	private Map<Character, Character> myCharMap;

	/**
	 * Create a HashMap which will store each character as it's key and value 
	 */
	public CeyKaps() {		
		initializeMap();
	}

	private void initializeMap(){
		myCharMap = new HashMap<Character, Character>();
		for (int i = 65; i < 91; i++) {
			// System.out.println((char) i);
			myCharMap.put((char) i, (char) i);
		}
	}
	
	public String decipher(String typed, String[] switches) throws Exception {
		initializeMap();
		
		
		String[] switchArr;
		String outputStr = null;

		
		for (String switchStr : switches) {
			//Split each of the switchStr for ":"
			switchArr = switchStr.split(":");
			//Throw an exception if the length is > 2, as we expect string in the format <Char1>:<Char2>
			if (switchArr.length > 2) {
				throw new UnsupportedCharsetException(
						"Unsupported switch string format");
			}
			
			Character char1Key = switchArr[0].charAt(0);
			Character char2Key = switchArr[1].charAt(0);

			/*Update the HashMap for the key.So if the switch is "A:B" then the key "A" in our hashMap will store "B" and key "B" will store "A"
			 * After the switch "A:B" if we have the switch "B:C" then the key "A" will store "C"(as key "A" was storing value "B" after previous switch)
			 * Key "C" will store value "B" after second switch.
			 */
			while (!myCharMap.get(char1Key).equals(switchArr[0].charAt(0))) {
				char1Key = myCharMap.get(char1Key);
			}
			while (!myCharMap.get(char2Key).equals(switchArr[1].charAt(0))) {
				char2Key = myCharMap.get(char2Key);
			}

			myCharMap.put(char1Key, switchArr[1].charAt(0));
			myCharMap.put(char2Key, switchArr[0].charAt(0));
		}

		for (char c : typed.toCharArray()) {
			if (outputStr == null) {
				outputStr = ((Character) myCharMap.get(c)).toString();
			} else {
				outputStr += ((Character) myCharMap.get(c)).toString();
			}
		}
		return outputStr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CeyKaps ceyKaps = new CeyKaps();

		String[] switches = new String[]  {"A:B","B:C","C:D","D:E","E:A"};//{ "W:O", "W:I" }; //{"A:B","B:C","A:D"};

		String typed = "ABCDE";//"IHWSIOTCHEDMYKEYCAPSARWUND";//"AAAAA";

		System.out.println("Typed String: " + typed);

		String output = null;

		try {
			output = ceyKaps.decipher(typed, switches);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Original string: " + output);

	}

}
