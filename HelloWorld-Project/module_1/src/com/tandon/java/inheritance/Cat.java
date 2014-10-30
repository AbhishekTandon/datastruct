package com.tandon.java.inheritance;

public class Cat extends Animal {
	String name;

	Cat(String baseName, String name) {
		super(baseName);
		this.name = name;
	}

	@Override
	public String getName() {
		return "a cat";
	}

	public String getBaseName() {
		return super.getName();
	}


	public static void main(String[] args) {
		Animal animal = new Cat("micky", "mammal");
		System.out.println("name of the animal >>" + animal.getName());

		Cat cat = new Cat("tom", "mammal");
		System.out.println("name of the animal base class >>" + cat.getBaseName());
	}

}
