package com.tandon.java.inheritance;

public class Animal {
	String name;

	Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return "an animal named >> " + this.name;
	}
}
