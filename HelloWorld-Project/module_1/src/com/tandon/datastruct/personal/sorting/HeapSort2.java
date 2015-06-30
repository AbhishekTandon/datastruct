package com.tandon.datastruct.personal.sorting;

/**
 * Refer following for heapSort implementation
 * http://www.sanfoundry.com/java-program-implement-heap-sort/

 */
public class HeapSort2 {
	public static void main(String[] args) {
		String str = "something string to sortz";
		char[] a = str.toCharArray();
		heap_sort(a, 0, 0);
	}


	public static void heap_sort(char[]  a, int position, int len) {
		if (position == len) return;
		while(position <= len) {
			if (a[position] < a[find_largest_child(a, position, len)]) {
				// swap the elements
				// call heap sort with position = find_largest_child(a, position, len)
			}
		}
	}


	public static int find_largest_child(char[] a, int position, int len) {
		int left = left_child(position);
		int right = right_child(position);

		if (left <= len && right <= len ) {
			if (a[left] < a[right]) return right;
			else return left;
		} else if (left <= len  && right > len)  {
			return left;
		} else if (left > len && right <= len) {
			return right;
		} else return -1;
	}

	public static int left_child(int pos) {
		return 2 * pos + 1;
	}

	public static int right_child(int pos) {
		return 2*pos + 2;
	}
}
