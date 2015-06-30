package com.tandon.datastruct.personal.list;

/**
 * TODO: implement peek and isEmpty methods
 */
public class ArrayStack {

	int size;
	String[] array;
	int pointer = -1;
	int factor = 2;

	public ArrayStack(int size) {
		this.size = size;
		array = new String [size];
	}

	public void push(String str) {
		ensure_capacity();
		if (pointer < size -1) {
			array[++pointer] = str;
			System.out.println(String.format("push: current location of the pointer(%s) value(%s)", pointer, str) );
		}
	}

	public String pop() {
		String ret;
		if (pointer >= 0 ) {
			ret = array[pointer];
			--pointer;
			System.out.println(String.format("pop: current location of the pointer(%s), value(%s)", pointer, ret));
		} else {
			throw new ArrayIndexOutOfBoundsException("no more entries in stack");
		}

		return ret;
	}

	public void ensure_capacity() {
		if (pointer == (array.length -1)) expand_capacity();
	}

	public void expand_capacity() {
		System.out.println("invoking expansion of array...");

		int new_length = size * factor;
		String[] new_array = new String[new_length];
		for (int i = 0; i < size; i++) new_array[i] = array[i];

		size = new_length;
		array = new_array;
	}


	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(3);
		try {
			stack.push("something 1");
			stack.push("something 2");
			stack.push("something 3");
			stack.push("something 4");
			stack.push("something 5");
		} catch (Exception ex){
			ex.printStackTrace();
		}

		try {
			System.out.println("entry from the stack >>" + stack.pop());
			System.out.println("entry from the stack >>" + stack.pop());
			System.out.println("entry from the stack >>" + stack.pop());
			System.out.println("entry from the stack >>" + stack.pop());
			System.out.println("entry from the stack >>" + stack.pop());
			System.out.println("entry from the stack >>" + stack.pop());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
