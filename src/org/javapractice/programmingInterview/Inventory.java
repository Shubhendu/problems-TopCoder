package org.javapractice.programmingInterview;

public class Inventory {

	private static final int numberOfDaysInMonth = 30;
	private static final double epsilon =1e-9;

	public int monthlyOrder(int[] sales, int[] daysAvailable) {
		double monthlySales = 0;
		int recordCount=0;
		double salesRate = 0 ;
		int expectedMonthlySales = 0;
		

		for (int i = 0; i < sales.length; i++) {
			if(daysAvailable[i] !=0){
				salesRate = ((double)sales[i] / (double)daysAvailable[i]);	
				monthlySales += salesRate * numberOfDaysInMonth;
				recordCount++;
			}
		}
		monthlySales = (monthlySales / recordCount) ;
		monthlySales-=epsilon;

		if (Math.ceil(monthlySales) == monthlySales) {
			expectedMonthlySales = (int) monthlySales;
		} else {
			expectedMonthlySales = (int) Math.ceil(monthlySales);
		}

		return expectedMonthlySales;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		Inventory inventory = new Inventory();
		int monthlySalesNumber = inventory.monthlyOrder(new int[] { 5 }, new int[] { 15 });
		System.out.println("Expected number of sales per month is: "+monthlySalesNumber);
		
		monthlySalesNumber = inventory.monthlyOrder(new int[] {75,120,0,93}, new int[] {24,30,0,30});
		System.out.println("Expected number of sales per month is: "+monthlySalesNumber);

		monthlySalesNumber = inventory.monthlyOrder(new int[] { 8773}, new int[] { 16});
		System.out.println("Expected number of sales per month is: "+monthlySalesNumber);
		
		monthlySalesNumber = inventory.monthlyOrder(new int[] { 1115, 7264,
				3206, 6868, 7301 }, new int[] { 1, 3, 9, 4, 18 });
		System.out.println("Expected number of sales per month is: "+monthlySalesNumber);
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken by the program: "+(endTime - startTime)+" ms");
		
	}

}
