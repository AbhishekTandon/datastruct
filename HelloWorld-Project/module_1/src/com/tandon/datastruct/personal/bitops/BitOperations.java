package com.tandon.datastruct.personal.bitops;

public class BitOperations {

	public static void main (String[] args) {
		int tmp = 20;
		int negnum = -1;
		System.out.println("mult by 2 using bit shifting (<<) " + (tmp << 2));
		System.out.println("mult by -2 using bit shifting (<<) " + (1000 << -2));
		System.out.println("divide by 2 using bit shifting (>>) " + (tmp >> 1));

		// uses 0 as the filler while shifting the bits to right
		System.out.println("shift 2's complement of -1 by 29 bits on right (unsigned shifting >>>) " + (negnum >>> 29));

		// uses the leftmost bit as the filler while shifting the bits to the right
		System.out.println("divide by 2 using signed bit shifting (>>) " + (-100 >> 1));

		System.out.println("mult by 2 using signed bit shifting >> " + (negnum << 2));


//		System.out.println("reverseByte operation >>" + Integer.reverseBytes(-5));
	}
}
