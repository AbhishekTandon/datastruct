package com.tandon.datastruct.personal.sorting;

import java.util.*;

public class SortingUsingStack {

	public static void main(String[] args) {
		Stack<String> input = new Stack();
		input.push("h");
		input.push("a");
		input.push("z");
		input.push("b");
		input.push("y");
		input.push("c");
		Stack<String> output = sortStack(input);
		while(!output.empty()) {
			System.out.println("String output >> " + output.pop());
		}

	}

	public static Stack<String> sortStack(Stack<String> input) {
		Stack<String> output = new Stack();
		if (input == null) return null;
		while(!input.empty()) {
			String tmp = input.pop();
			if (!output.empty() && tmp.compareTo(output.peek()) >= 0) {
				output.push(tmp);
			} else {
				while(!output.empty() && output.peek().compareTo(tmp) > 0) {
					input.push(output.pop());
				}
				output.push(tmp);
			}

		}
		return output;
	}

}
