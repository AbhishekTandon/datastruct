package com.tandon.java.innerclasses;

public class InnerClassTest {

	private int y = 0;
	private static int static_outer_param = 4;

	class FirstLevel {
		public int x = 1;
//		public static int static_param_x = 3;

		void methodInFirstLevel(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("ShadowTest.this.x = " + InnerClassTest.this.y);
		}
	}

	static class StaticInnerClass {
		public static int x = 1;

		static void methodStaticInnerClass(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + StaticInnerClass.x);

			/**
			 * variables of the enclosing class cannot be accessed from static inner class
			 */
//			System.out.println("ShadowTest.this.x = " + InnerClassTest.this.y);
			System.out.println("ShadowTest.this.x = " + InnerClassTest.static_outer_param);
		}
	}

	public static void main(String... args) {
		InnerClassTest st = new InnerClassTest();
		InnerClassTest.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);

		InnerClassTest.StaticInnerClass staticClass = new InnerClassTest.StaticInnerClass();
		InnerClassTest.StaticInnerClass.methodStaticInnerClass(3);


	}
}