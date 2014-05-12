package org.javapractice.programmingInterview;

public class TireRotation {

	public static int getCycle(String initial, String current) {
		int phase = -1;
		String currentPhase = null;
		currentPhase = initial;
		
		for (int i = 1; i <= 4; i++) {
			if (current.equals(currentPhase)) {
				phase = i;
				break;
			}
			currentPhase = rotateTires(currentPhase);
		}
		return phase;

	}

	private static String rotateTires(String currentPhase) {
		String rotatedTirePos = null;

		rotatedTirePos = currentPhase.substring(3, 4)
				+ currentPhase.substring(2, 3) + currentPhase.substring(0, 1)
				+ currentPhase.substring(1, 2);

		return rotatedTirePos;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getCycle("ABCD", "ABCD"));
		System.out.println(getCycle("ABCD", "DCAB"));
		System.out.println(getCycle("ABCD", "CDBA"));
		System.out.println(getCycle("ABCD", "ABDC"));
		System.out.println(getCycle("ZAXN", "XNAZ"));

	}

}
