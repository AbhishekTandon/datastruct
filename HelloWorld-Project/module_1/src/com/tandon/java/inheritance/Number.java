package com.tandon.java.inheritance;

public class Number<T> implements Expression<T> {
	T value;

	Number(T num) {
		value = num;
	}

	public T getValue() {
		return value;
	}

}
