package com.tandon.datastruct.personal.search;

//http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
public class SortedMatrix {

	static int search(int[][] mat, int n, int x) {
		int i = 0, j = n - 1;  //set indexes for top right element
		while (i < n && j >= 0) {
			if (mat[i][j] == x) {
				System.out.println(String.format("\n Found at %s, %s", i, j));
				return 1;
			}

			if (mat[i][j] > x) j--;
			else //  if mat[i][j] < x
				i++;
		}

		System.out.println("\n Element not found");
		return 0;  // if ( i==n || j== -1 )
	}

	// driver program to test above function
	public static void main(String[] args) {
		int[][] mat={
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50}} ;


		search(mat, 4, 29);
	}
}
