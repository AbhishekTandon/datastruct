package datastruct.personal.stringops;

import java.util.LinkedList;

public class TestUniqueChar {

	public static void main(String[] args) {
		String something = "somethingg";
		System.out.println(String.format("The characters in the string are unique (%s)", (isUniqueChars2(something))));

		char[] chars = something.toCharArray();
		StringBuilder buffer = new StringBuilder();
		for(char c: reverseChars(chars)) buffer.append(c);
		System.out.println(String.format("Reverse string is (%s)", buffer.toString()));

		String duplicateString  = "abadafef";
		LinkedList lst = new LinkedList();

	}


	/** Testing scenarios
	 * 1. String length is 0 or 1
	 * 2. String length > 1
	 */
	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}

	/** Testing scenarios
	 * 1. when the length is 0
	 * 2. when length = 1
	 * 3. for any other length
	 */
	public static char[] reverseChars(char[] chars) {
		int end =  chars.length - 1;
		char tmp;
		for (int i = 0;  i < end ; i++) {
			tmp = chars[i];
			chars[i] = chars[end];
			chars[end] = tmp;
			end --;
		}
		return chars;
	}
}
