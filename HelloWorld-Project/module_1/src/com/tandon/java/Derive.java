package com.tandon.java;

class Base {
	public void fun() {
		System.out.println("Base fun");
	}
}

class Derived extends Base {
	public void fun() {
		System.out.println("Derived fun");
	}

	public static void main(String[] args) {
		Base obj = new Derived();
		Boolean flag = Boolean.FALSE;
		obj.fun();
	}
}