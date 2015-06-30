package com.tandon.datastruct.personal.integerOps;

/**
 * wrong implementation
 */
public class FindNextHigherNumber {
	public static void main(String[] main) {
		int[] arr = {12, 15, 22, 9, 7, 2, 18, 23, 27};
	}

	public static void find_next_higher(int[] numbers) {
		int len = numbers.length;
		int ret = -1;
		int[] aux = new int[len];

		for (int i = len - 1; i >= 0; i++) {
			if (i >= len) {

			} else if (numbers[i+1] > numbers[i]){
				ret = numbers[i+1];
			}
		}
	}

}
