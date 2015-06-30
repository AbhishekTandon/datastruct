package com.tandon.datastruct.personal.integerOps;

import java.util.*;

public class NumOperations {

	public static void main(String[] args) {
		int ret = fibonacciIterative(4);
		System.out.println(String.format("fibonacci response >> %s", ret));
	}

	//recursive function calculates n!
	public static int factorialRecursive(int n)
	{
		if (n <= 1) return 1;
		return n * factorialRecursive(n - 1);
	}

	//iterative function calculates n!
	public static int factorialIterative(int n)
	{
		int sum = 1;
		if (n <= 1) return sum;
		while (n > 1)
		{
			sum *= n;
			n--;
		}
		return sum;
	}


	//--------------- iterative version ---------------------
	static int fibonacciIterative(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;

		int prevPrev = 0;
		int prev = 1;
		int result = 0;

		for (int i = 2; i <= n; i++)
		{
			result = prev + prevPrev;
			prevPrev = prev;
			prev = result;
		}
		return result;
	}

	//--------------- naive recursive version ---------------------
	static int fibonacciRecursive(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;

		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	//--------------- optimized recursive version ---------------------
	static Map<Integer,Integer> resultHistory = new HashMap();

	static int fibonacciRecursiveOpt(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (resultHistory.containsKey(n)) return resultHistory.get(n);

		int result = fibonacciRecursiveOpt(n - 1) + fibonacciRecursiveOpt(n - 2);
		resultHistory.put(n, result);

		return result;
	}
}
