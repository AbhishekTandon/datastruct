package com.tandon.java;

import java.util.*;
public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap();

		map.put(21, "Twenty One");
		map.put(22, "Twenty two");

		String value = map.get(21);
		System.out.println(" map information >> " + value);

	}

}
