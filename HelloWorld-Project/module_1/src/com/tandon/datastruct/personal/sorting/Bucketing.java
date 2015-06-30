package com.tandon.datastruct.personal.sorting;

public class Bucketing {

	public static void main(String[] args) {
		int[] numbers = {-1, 1, 0, 3, 7, 0, -5, 7, -8, -11, 6, 13, 8, 0, 1, 0};
		int length = numbers.length;
		int positive_numbers = 0;
		int negative_numbers = 0;
		int zeros = 0;

		for(int i = 0; i < length; i++) {
			if (numbers[i] < 0) ++negative_numbers;
			else if (numbers[i] == 0) ++zeros;
			else if (numbers[i] > 0) ++ positive_numbers; // No point of this one
		}

		int negative_pointer = 0;
		int zero_pointer = 0 + negative_numbers;
		int positive_pointer = zero_pointer + zeros;
		int[] numbers_aux = new int[length];
		for(int i = 0; i < length; i++) {
			int number = numbers[i];
			if (numbers[i] < 0) {
				numbers_aux[negative_pointer++] = number;
			} else if (numbers[i] == 0) {
				numbers_aux[zero_pointer++] = number;
			} else if (numbers[i] > 0) {
				numbers_aux[positive_pointer++] = number;
			}
		}

		for(int i = 0; i < length; i++) {
			System.out.println(String.format("output number[%s]=%s", i, numbers_aux[i]));
		}

	}

}
