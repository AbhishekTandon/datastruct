package com.tandon.datastruct.personal.integerOps;

public class PrimeCount {

	public static void main(String[] args) {
		System.out.println("number of 5 >> " + number_of_prime(4, 5));
	}


	public static int number_of_prime(int num, int prime) {
		int count = 0;
		int i ;
		for (i = prime; i < num; i = i * 5) {
			count += num/i;
		}
		return count;
	}

	public int nearest_number(int num) {
		return 0;
	}

}
