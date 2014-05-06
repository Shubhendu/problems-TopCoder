/** Copyright @ Cisco Systems Inc.
 *  Created Jan 10, 2014
 */
package org.javapractice.dynamicconnectivity;

/**
 * @author shusingh
 * 
 */
public class Percolation {
	

	int[][] grid;
	int openSitesCount = 0;
	WeightedQuickUnionUF quickUnion;

	public Percolation(int N) // create N-by-N grid, with all sites blocked
	{
		grid = new int[N][N];
		quickUnion = new WeightedQuickUnionUF(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = 0;
			}
		}

	}

	public void open(int i, int j) throws IndexOutOfBoundsException
	{
		int N = grid.length;
		if (i > N || j > N || i < 1 || j < 1) {
			throw new IndexOutOfBoundsException(
					"Index is out of the size of Grid " + N);
		} else {
			if (!isOpen(i, j)) {
				grid[i][j] = 1;
				openSitesCount++;
				int index = N * (i - 1) + j;
				int rightIndex = index + 1;
				int leftIndex = index - 1;
				int bottomIndex = index + N;
				int topIndex = index - N;

				double gridN = Math.sqrt(N);

				if (rightIndex <= gridN) {
					if (isOpen(i, j + 1)) {
						quickUnion.union(index, rightIndex);
					}
				}

				if (leftIndex > 0) {
					if (isOpen(i, j - 1)) {
						quickUnion.union(index, leftIndex);
					}
				}

				if (bottomIndex <= gridN) {
					if (isOpen(i + 1, j)) {
						quickUnion.union(index, bottomIndex);
					}
				}

				if (topIndex > 0) {
					if (isOpen(i - 1, j)) {
						quickUnion.union(index, topIndex);
					}
				}

			}
		}

	}

	public boolean isOpen(int i, int j) // is site (row i, column j) open?{
	{
		if (grid[i][j] == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isFull(int i, int j) // is site (row i, column j) full?
	{
		int N = grid.length;
		int index = N * (i - 1) + j;
		int rightIndex = index + 1;
		int leftIndex = index - 1;
		int bottomIndex = index + N;
		int topIndex = index - N;
		boolean isFull = false;

		double gridN = Math.sqrt(N);

		if (rightIndex <= gridN) {
			isFull =  quickUnion.connected(i, j + 1);
		}

		if (leftIndex > 0) {
			isFull = quickUnion.connected(i, j - 1);		
		}

		if (bottomIndex <= gridN) {
			isFull = quickUnion.connected(i + 1, j);			
		}

		if (topIndex > 0) {
			isFull = quickUnion.connected(i - 1, j);			
		}


		return isFull;
	}
	// public boolean percolates()

}
