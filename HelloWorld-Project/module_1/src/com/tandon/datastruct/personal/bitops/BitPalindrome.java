package com.tandon.datastruct.personal.bitops;

/**
 * TODO: Test with -ve integer
 */
public class BitPalindrome {
	public static void main(String[] args) {
		final int INT_LENGTH = 32;
		int input = 0x7000000e; // is a palindrome

		System.out.println(String.format("input %s is palindrome = %s", input, isPalindrome(input, INT_LENGTH)));
	}

	public static boolean isPalindrome(int in, int length) {
		int k = length - 1;
		int l = 0;
		while(l < k) {
			if (isKthBitSet(in, l) != isKthBitSet(in, k)) {
				return false;
			}
			l++; k--;
		}
		return true;
	}

	public static boolean isKthBitSet(int input, int k) { return (input & (1 << k)) > 0; }
}
