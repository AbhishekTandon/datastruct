package datastruct.personal.stringops;

import java.util.ArrayList;

public class StringOperations {
	public static void main(String[] args) {
		String str = "some string to process ";
		char[] chars = str.toCharArray();

		char[] repStr = ReplaceFun(chars, chars.length);

		for (char c : repStr) System.out.println("char >>" + c);

		String tmp = "caabbbdd";
		char[] char_array = tmp.toCharArray();
		int count = longestRun(char_array);
		System.out.println(String.format("longest run (%s)", count));

		reverse_string(char_array);
		System.out.println(String.format("printing the reverse string {%s}", new String(char_array)));

		String test = "caacbbbdd";
		remove_duplicate_from_string(test.toCharArray());
		string_compression(test.toCharArray());

		String test2 = "I am in New   York City";
		remove_extra_space_from_string(test2.toCharArray());

		String test3 = "I am in New   York City ";
		char[] char_array3 = test3.toCharArray();
		reverse_words_in_string(char_array3);
		System.out.println(String.format("reverse word in string {%s}", new String(char_array3)));
	}

	/** replace all space with something else*/
	public static char[] ReplaceFun(char[] str, int length) {

		int spaceCount = 0, newLength, i = 0;

		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * (3 - 1);
		char[] repStr = new char[newLength];
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				repStr[newLength - 1] = '0';
				repStr[newLength - 2] = '2';
				repStr[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				repStr[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return repStr;
	}

	/** longest sequence of some character */
	public static int longestRun(char[] string) {
		int maxRun = 0;
		int run = 0;
		char previous;
		if (string.length == 0) return maxRun;
		else if (string.length == 1) {
			return ++maxRun;
		} else {
			previous = string[0];
			++maxRun;
			++run;
			for (int i = 1; i < string.length; i++) {
				if (string[i] == previous) {
					++run;
				} else { // resetting the previous, maxRun, run
					if (run > maxRun) maxRun = run; // copy the value of run to maxRun
					previous = string[i];
					run = 1; // resetting the counter
				}
			}
		}

		return maxRun;
	}

	/**reverse the string*/
	public static void reverse_string(char[] string) {
		int length = string.length;
		if (length > 1) {
	   	    int i = 0;
			int k = length - 1;
			char tmp;
			while( k > i) {
				tmp = string[k];
				string[k] = string[i];
				string[i] = tmp;
				k--; i++;
			}
		}
	}

	/** Should throw exception on length = 0*/
	public static void remove_duplicate_from_string(char[] in) {
		int len = in.length;
		ArrayList<Character> duplicate_removed = new ArrayList();
		int j = 0;
		duplicate_removed.add(in[j]);
		for (int i = 1; i < len; i++) {
			if (in[i] == in[j]) {
				// Do Nothing and increase the 'i' pointer
			} else if (in[i] != in[j]) {
				j = i;
				duplicate_removed.add(in[i]);
			}
		}

		int output_len = duplicate_removed.size();
		char[] output_array = new char[output_len];
		for(int i = 0; i < output_len; i++) {
			output_array[i] = duplicate_removed.get(i);
		}
		System.out.println("non duplicate string >> " + new String(output_array));
	}

	/** Should throw exception on length = 0*/
	public static void string_compression(char[] in) {
		int len = in.length;

		if (len >= 1) {
			char[] compressed_string = new char[len];
			int k = 0;
			int count =  1; // this should be moved inside the for logic
			char tmp = in[0];
			// modify code so that index 'i'  starts @ 0
			for (int i = 1; i < in.length ; i++) {
				if (in[i] == in[i-1]) count++;
				else if (in[i] != in[i-1]) {
					compressed_string[k++] = tmp;
					compressed_string[k++] = (char)('0' + count);
					count = 1;
					tmp = in[i];
				}
			}

			System.out.println(String.format("compressed string output (%s) and input (%s)", new String(compressed_string), new String(in)));

		} else {
			return;
		}

	}

	/**remove extra space from string**/
	public static void remove_extra_space_from_string(char[] in) {
		char space = ' ';
		int j = 0;
		int len = in.length;
		ArrayList<Character> space_removed = new ArrayList();

		space_removed.add(in[j]);
		for (int i = 1; i < len; i++) {
			if (in[i] == space && in[i] == in[j]) {
				// Do Nothing and increase the 'i' pointer
			} else {
				j = i;
				space_removed.add(in[i]);
			}

		}

		int output_len = space_removed.size();
		char[] output_array = new char[output_len];
		for(int i = 0; i < output_len; i++) {
			output_array[i] = space_removed.get(i);
		}
		System.out.println(String.format("space removed from string {%s}", new String(output_array)));
	}

	/**
	 * reverse words in the string
	 */
	public static void reverse_words_in_string(char[] a) {
		reverse_substring(a, 0, a.length - 1);

		int startIndex = 0;
		int endIndex = 0;
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i] == ' ' && a[i-1] != ' ') { // end of a word
				reverse_substring(a, startIndex, endIndex);
			} else if (a[i] != ' ' && a[i-1] == ' ') {// start new word
				startIndex = i;
				endIndex = i;
			} else if (a[i] != ' ' && a[i-1] != ' ') { // inside word
				++endIndex;
			} else if (a[i] == ' ' && a[i-1] == ' ') {
				//Do Nothing
			}
		}
	}

	/**reverse substring*/
	public static void reverse_substring(char[] string, int startIndex, int endIndex) {
		if (endIndex == startIndex) return;
		else {
				while( endIndex > startIndex) {
					char tmp = string[endIndex];
					string[endIndex] = string[startIndex];
					string[startIndex] = tmp;
					endIndex--; startIndex++;
				}
		}
	}
}
