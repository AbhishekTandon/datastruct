package com.tandon.datastruct.personal.permutation.dynamic.programming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		char[] x = "AGGTAB".toCharArray();
		char[] y = "GXTXAYB".toCharArray();
		int lcs = get_lcs(x, y, 0, 0);
		System.out.println("longest common sequence >>" + lcs);

	}

	public static int get_lcs(char[] x, char[] y, int pos_x, int pos_y) {
		int count = 0;
		for (int i = pos_x; i < x.length; i++ ) {
			char a = x[i];
			for (int k = pos_y; k < y.length; k++) {
				if (a == y[k]) count = Math.max(count, 1 +  get_lcs(x, y, i + 1, k + 1));
			}

		}

		return count;
	}
}
