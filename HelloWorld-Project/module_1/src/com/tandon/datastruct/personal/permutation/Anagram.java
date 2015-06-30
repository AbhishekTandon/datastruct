package com.tandon.datastruct.personal.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Sort  and remove  duplicate String
 * if there are duplicate characters
 */
public class Anagram {
	public static void main(String[] args) {
		String str = "abca";
		char[] a = str.toCharArray();
		int length = a.length;

		List<Character[]> subset = new ArrayList<>();

		if (subset.size() == 0) subset.add(new Character[length]);

		for (int i = 0; i < a.length; i++) {
			List<Character[]> auxSubset = new ArrayList<>();
			for (int k = 0; k < subset.size(); k++) {
				Character[] arr = subset.get(k);
				for (int l = 0; l < length; l++) {
					if (arr[l] == null) {
						Character[] cloned = clone(arr);
						cloned[l] = a[i];
						auxSubset.add(cloned);
					}
				}
			}

			subset = auxSubset;
		}

		int num = 1;
		for (Character[] list : subset) {
			StringBuilder builder = new StringBuilder();
			for (Character c : list) builder.append(c);
			System.out.println(String.format("possible anagram (%s) is {%s}", num++, builder.toString()));
		}

	}

	public static void swap(char[] a, int i, int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static Character[] clone(Character[] a) {
		Character[] cloned = new Character[a.length];
		for (int i = 0; i < a.length; i++) cloned[i] = a[i];
		return cloned;
	}

	class AnagramComparator implements Comparator<String> {
		public String sortChars(String s) {
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}

		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}


}
