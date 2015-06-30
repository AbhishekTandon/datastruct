package com.tandon.datastruct.personal.integerOps;

/**
 * Find index for the inout in the sorted array using binary search - recursion
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 7, 9, 11, 13, 16};
		int length = numbers.length;
		int max = length - 1;
		int min = 0;
		int in = 4;

		int index1 = binary_search_recursion(numbers, in, max, min);
		System.out.println(String.format("recursive - index of the number (%s) is (%s)", in, index1));

		int index2 = binary_search_iteration(numbers, in);
		System.out.println(String.format("iteration - index of the number (%s) is (%s)", in, index2));

		int[] array = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		int res = find_first_instance(array, 285);
		System.out.println(String.format("index of the first instance of the number %s", res));
	}

	public static int binary_search_recursion(int[] numbers, int num, int max, int min) {
		int index = min + ((max - min) / 2);

		if (numbers[index] == num) {
			return index;
		} else {
			if (numbers[index] < num && min != index) {
				min = index;
				return binary_search_recursion(numbers, num, max, min);
			} else if (numbers[index] > num && max != index) {
				max = index;
				return binary_search_recursion(numbers, num, max, min);
			} else { // number[index] ==  num
				return -1;
			}
		}
	}

	public static int binary_search_iteration(int[] numbers, int input) {
		int max = numbers.length -1;
		int min = 0;
		while(max >= min) {
			int mid = min + (max-min)/2; // this avoid overflow
			if (numbers[mid] == input) {
				return mid;
			} else {
				if (max != mid &&  min != mid) {
					if (numbers[mid] > input) {
						max = mid + 1;
					} else if(numbers[mid] < input) {
						min = mid - 1;
					}
				} else {
					return -1;
				}
			}
		}
		return 0;
	}


	public static int find_first_instance(int[]  numbers, int input) {
		int res = -1;
		int max = numbers.length -1;
		int min = 0;

		while(max >= min) {
			int mid = min + ((max-min) >> 1); // this avoid overflow
			if (numbers[mid] > input) {
				max = mid - 1;
			} else  if (numbers[mid] == input){
				// record the solution and keep searching
				res = mid; max = mid -1;
			} else {
				min = mid + 1;
			}
		}
		return res;
	}

}
