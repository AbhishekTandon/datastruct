package com.tandon.java.inheritance;

public class Mammal implements Animal {
	String name;

	Mammal(String name) {
		this.name = name;
	}

	public String getName() {
		return "an animal named >> " + this.name;
	}

	public static String getStaticName() {
		return "Mammal class";
	}
}
