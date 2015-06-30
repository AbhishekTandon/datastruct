package com.tandon.datastruct.personal.math;

public class GCD {

	public static void main(String[] args) {
		long a = 15;
		long b = 12;
		long gcd = compute_gcd(12, 15);
		System.out.println(String.format("GCD of numbers (%s) (%s) is >> %s", a, b, gcd));
	}

	static long compute_gcd(long a, long b) {
		long r;
		while(b!=0){
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
