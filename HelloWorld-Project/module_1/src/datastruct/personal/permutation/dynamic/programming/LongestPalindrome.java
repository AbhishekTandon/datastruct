package datastruct.personal.permutation.dynamic.programming;

public class LongestPalindrome {
	static int max_len = 0;
	public static void main(String[] args) {
		char[] arr = "BBABCBAB".toCharArray();

		for (int start = 0; start < arr.length; start++) {
			for (int end = start + 1; end < arr.length; end++) {
				get_longest_palindrome(arr, start, end);
			}
		}

		System.out.println(String.format("length of the palindrome >> %s; array length %s", max_len, arr.length));
	}

	public static boolean get_longest_palindrome(char[] arr, int start, int end) {
		if (start == end)  return true;

		if (start < end && start >=0 && start < arr.length && end >=0 && end < arr.length) {
			// create a cache to avoid recursive call to the same function
			if (arr[start] == arr[end] && get_longest_palindrome(arr, start + 1, end - 1)) {
				max_len = Math.max(max_len, end - start + 1);
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
}
