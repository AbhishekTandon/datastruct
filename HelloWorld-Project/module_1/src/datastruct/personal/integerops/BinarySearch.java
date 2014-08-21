package datastruct.personal.integerops;

/**
 * Find index for the inout in the sorted array using binary search - recursion
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 7, 9, 11, 13, 16};
		int length = numbers.length;
		int max = length - 1;
		int min = 0;
		int in = 17;
		int index = get_index_of_number(numbers, in, max, min);

		System.out.println(String.format("index of the number (%s) is (%s)", in, index));
	}

	public static int get_index_of_number(int[] numbers, int num, int max, int min) {
		int index = (max + min) / 2;

		if (numbers[index] == num) {
			return index;
		} else {
			if (numbers[index] < num && min != index) {
				min = index;
				return get_index_of_number(numbers, num, max, min);
			} else if (numbers[index] > num && max != index) {
				max = index;
				return get_index_of_number(numbers, num, max, min);
			} else { // number[index] ==  num
				return -1;
			}
		}


	}
}
