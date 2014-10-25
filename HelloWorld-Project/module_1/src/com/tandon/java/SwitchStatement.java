package com.tandon.java;

public class SwitchStatement {

	public static void main(String[] args) {

		System.out.println(" response >>" + atoi(5));

	}

	public static char atoi(int number) {

		char resp;
		switch (number) {
			case 1: resp = '1';
				break;
			case 2: resp = '2';
				break;
			case 3: resp = '3';
				break;
			default: resp = 'x';
				break;
		}

		return resp;
	}

}
