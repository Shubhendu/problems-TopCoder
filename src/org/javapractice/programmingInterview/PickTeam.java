/** Copyright @ Cisco Systems Inc.
 *  Created May 8, 2014
 */
package org.javapractice.programmingInterview;

/**
 * @author shusingh
 * 
 */
public class PickTeam {
	
	private static int[][] compatibilityArr;
	private static String[] peopleName;
	private static int[] outputIndexArr;
	private static int maxTeamCompatibility;


	private void initializeParams(int teamSize, String[] people){
		int size = people.length;
		peopleName = new String[size];
		compatibilityArr = new int[size][size];
		outputIndexArr = new int[teamSize];
		maxTeamCompatibility = Integer.MIN_VALUE;
		
		int countRecord = 0;
		String[] peopleRecord = null;

		for (String peopleData : people) {
			peopleRecord = peopleData.split(" ");
			peopleName[countRecord] = peopleRecord[0];
			for (int i = 1; i < peopleRecord.length; i++) {
				compatibilityArr[countRecord][i - 1] = Integer.valueOf(peopleRecord[i]);
			}
			countRecord++;
		}
		
	}

	public String[] pickPeople(int teamSize, String[] people) {
		
		initializeParams(teamSize, people);
		
		int[] compatibilityIndexArr = new int[people.length];
		String[] bestTeam = new String[teamSize];
		
		findCombination(compatibilityIndexArr, teamSize);

		int count = 0;
		for(int i : outputIndexArr){
			bestTeam[count++] = peopleName[i];
		}

		return bestTeam;
	}

	private void findCombination(int[] arr, int r) {
		int data[] = new int[r];
		int n = arr.length;
		combinationUtil(arr, data, 0, n - 1, 0, r);

	}

	private void combinationUtil(int arr[], int data[], int start,
			int end, int index, int r) {
		if (index == r) {
			int sum = 0;
			
			for (int j = 0; j < r - 1; j++) {
				for(int k=j+1;k<r;k++){
					sum+=compatibilityArr[data[j]][data[k]];
				}
			}
//			System.out.println("sum = "+sum);
			if (sum > maxTeamCompatibility) {
				maxTeamCompatibility = sum;
				outputIndexArr = data.clone();
			}
			
		}

		for (int i = start; i <= end && index < r; i++) {
				data[index] = i;
				combinationUtil(arr, data, i + 1, end, index + 1, r);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] people = null;
		int teamSize = 0;
		String[] team;
		PickTeam pickTeam;
		
		long startTime = System.currentTimeMillis();
		
		people = new String[] { "ALICE 0 1 -1 3", "BOB 1 0 2 -4",
				"CAROL -1 2 0 2", "DAVID 3 -4 2 0" };
		teamSize = 3;
		
		System.out.println("---------------------Test case 1----------------------------");
		pickTeam = new PickTeam();		
		team = pickTeam.pickPeople(teamSize, people);
		System.out.print("Best team is : ");
		for (String teamPersonnel : team){
			System.out.print(teamPersonnel+"\t");
		}
		System.out.println("\nThis team has "+PickTeam.maxTeamCompatibility+" compatibility points");
		
		
		System.out.println("---------------------Test case 2----------------------------");
		pickTeam = new PickTeam();	
		people = new String[]
		{"ALICE 0 1 -1 3",
			 "BOB 1 0 2 -4",
			 "CAROL -1 2 0 2",
			 "DAVID 3 -4 2 0"};

		teamSize = 2;
		team = pickTeam.pickPeople(teamSize, people);
		System.out.print("Best team is : ");
		for (String teamPersonnel : team){
			System.out.print(teamPersonnel+"\t");
		}
		System.out.println("\nThis team has "+PickTeam.maxTeamCompatibility+" compatibility points");
		
		
		System.out.println("---------------------Test case 3----------------------------");
		pickTeam = new PickTeam();	
		people = new String[]{"A 0 -2 -2","B -2 0 -1","C -2 -1 0"};
		teamSize = 2;
		team = pickTeam.pickPeople(teamSize, people);
		System.out.print("Best team is : ");
		for (String teamPersonnel : team){
			System.out.print(teamPersonnel+"\t");
		}
		System.out.println("\nThis team has "+PickTeam.maxTeamCompatibility+" compatibility points");

		System.out.println("---------------------Test case 4----------------------------");
		pickTeam = new PickTeam();	
		people = new String[]{"A 0 2 8 7 1 -4 -3 1 8 2 8 2 1 -3 7 1 3 9 -6 -5",
			 "A 2 0 0 7 -7 -5 8 -8 -9 -9 6 -9 -4 -8 8 1 7 0 3 3",
			 "A 8 0 0 -5 -5 -7 1 -3 1 9 -6 6 1 5 6 -9 8 6 -8 -8",
			 "A 7 7 -5 0 7 -5 3 9 8 3 -6 -5 -5 2 -6 2 -2 -1 -2 8",
			 "B 1 -7 -5 7 0 7 -2 -9 3 7 0 -2 1 1 -9 -3 -2 2 1 -2",
			 "B -4 -5 -7 -5 7 0 4 8 6 0 -1 4 1 -2 -9 4 0 -7 6 -2",
			 "B -3 8 1 3 -2 4 0 8 -1 1 -2 -7 5 0 -6 9 0 -3 1 3",
			 "B 1 -8 -3 9 -9 8 8 0 0 -2 5 0 5 8 3 5 2 4 5 4",
			 "C 8 -9 1 8 3 6 -1 0 0 8 -3 8 -6 -4 7 -4 1 -5 5 4",
			 "C 2 -9 9 3 7 0 1 -2 8 0 -9 -6 6 5 -8 -3 -8 2 2 4",
			 "C 8 6 -6 -6 0 -1 -2 5 -3 -9 0 2 7 8 2 -6 -4 -6 4 4",
			 "C 2 -9 6 -5 -2 4 -7 0 8 -6 2 0 0 -3 6 7 -1 2 -4 -2",
			 "D 1 -4 1 -5 1 1 5 5 -6 6 7 0 0 -7 -4 8 -6 -3 4 -6",
			 "D -3 -8 5 2 1 -2 0 8 -4 5 8 -3 -7 0 7 -3 5 -8 5 1",
			 "D 7 8 6 -6 -9 -9 -6 3 7 -8 2 6 -4 7 0 9 -5 -5 -8 3",
			 "D 1 1 -9 2 -3 4 9 5 -4 -3 -6 7 8 -3 9 0 -2 -7 8 -7",
			 "E 3 7 8 -2 -2 0 0 2 1 -8 -4 -1 -6 5 -5 -2 0 6 0 5",
			 "E 9 0 6 -1 2 -7 -3 4 -5 2 -6 2 -3 -8 -5 -7 6 0 4 8",
			 "E -6 3 -8 -2 1 6 1 5 5 2 4 -4 4 5 -8 8 0 4 0 1",
			 "E -5 3 -8 8 -2 -2 3 4 4 4 4 -2 -6 1 3 -7 5 8 1 0"};

		teamSize = 13;
		team = pickTeam.pickPeople(teamSize, people);
		System.out.print("Best team is : ");
		for (String teamPersonnel : team){
			System.out.print(teamPersonnel+"\t");
		}
		System.out.println("\nThis team has "+PickTeam.maxTeamCompatibility+" compatibility points");
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken by the program: "+(endTime - startTime)+" ms");
	}

}
