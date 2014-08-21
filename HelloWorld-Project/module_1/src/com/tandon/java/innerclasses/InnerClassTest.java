package com.tandon.java.innerclasses;

public class InnerClassTest {

	private int y = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("ShadowTest.this.x = " + InnerClassTest.this.y);
		}
	}

	static class StaticInnerClass {
		public int x = 1;
		void methodStaticInnerClass(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);

			/**
			 * variables of the enclosing class cannot be accessed from static inner class
			 */
//			System.out.println("ShadowTest.this.x = " + InnerClassTest.this.y);
		}
	}

	public static void main(String... args) {
		InnerClassTest st = new InnerClassTest();
		InnerClassTest.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}