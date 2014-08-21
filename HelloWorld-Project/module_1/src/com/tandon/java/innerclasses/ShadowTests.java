package com.tandon.java.innerclasses;

public class ShadowTests {

	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("ShadowTest.this.x = " + ShadowTests.this.x);
		}
	}

	public static void main(String... args) {
		ShadowTests st = new ShadowTests();
		ShadowTests.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}