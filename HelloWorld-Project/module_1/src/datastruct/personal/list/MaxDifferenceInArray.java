package datastruct.personal.list;

public class MaxDifferenceInArray {

	public static void main(String[] args) {
		int[] A = { 10, 3, 6, 8, 9, 4, 1, 6 };
		int ret = solution(A);
		System.out.println("response >>" + ret);
		maxDiff(A);
	}


	public static int solution(int[] A) {
		int N = A.length;
		if (N < 1) return 0;

		int max = 0;
		int result = 0;

		for(int i = N-1; i >= 0; --i) {
			if(A[i] > max) max = A[i];

			int tmpResult = max - A[i];
			if(tmpResult > result) result = tmpResult;
		}

		return result;
	}

	/**
	   The function assumes that there are at least two elements in array.
        The function returns a negative value if the array is sorted in decreasing order.
        Returns 0 if elements are equal

	 Algorithm:
	    1) Maximum difference found so far (max_diff).
	    2) Minimum number visited so far (min_element).
	 */

	public static int maxDiff(int arr[]) {
		int length = arr.length;
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		int max_element = arr[1];

		for(int i = 1; i < length; i++) {
			int new_diff ;
			if((new_diff = arr[i] - min_element) > max_diff) {
				max_diff = new_diff;
				max_element = arr[i];
			}

			if(arr[i] < min_element) {
				min_element = arr[i];
			}
		}


		System.out.println(String.format("out of max diff max > %s; min > %s, diff > %s", max_element, min_element, max_diff));
		return max_diff;
	}


}
