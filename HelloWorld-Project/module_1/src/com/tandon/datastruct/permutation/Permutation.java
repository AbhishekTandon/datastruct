package com.tandon.datastruct.permutation;

public class Permutation {

	public static void main(String[] main) {
		int[] numbers = {1, 2, 3, 4, 5, 7, 9, 11, 13, 16};
		int r = 3;
		int[] tmp = new int[r];
		get_permutations(numbers, r, 0, tmp);
	}

	public static void get_permutations(int[] numbers, int r, int level, int[] tmp) {

		if (level == r) {
			StringBuilder buffer = new StringBuilder();
			for (int j = 0; j < tmp.length; j++) buffer.append(tmp[j]).append(' ');
			System.out.println("possible combination >> " + buffer.toString());
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			tmp[level] = numbers[i];
			get_permutations(numbers, r, level + 1, tmp);
		}
	}
}
