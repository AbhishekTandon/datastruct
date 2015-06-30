package com.tandon.java.inheritance;

public class Cat extends Mammal {

	String name;

//	@Override public String instanceName;

	Cat(String baseName, String name) {
		super(baseName);
		this.name = name;
	}

	@Override
	public String getName() {
		return super.getName() + " cat";
	}

	public String getBaseName() {
		return super.getName();
	}

	public static String getStaticName() {
		return "Cat class";
	}

	public static void main(String[] args) {
		Mammal animal = new Cat("micky", "mammal");
		System.out.println("name of the animal >>" + animal.getName());

		Cat cat = new Cat("tom", "mammal");
		System.out.println("name of the animal base class >>" + cat.getBaseName());

		System.out.println("Printing the className >>" + Cat.className);
		System.out.println("Printing the className >>" + animal.instanceName);

		System.out.println("Accessing static method  >>" + cat.getStaticName());
		System.out.println("Accessing static method  of parent >>" + animal.getStaticName());

	}

}
