package com.tandon.datastruct.personal.integerOps;

/**
 * Find square root using binary search
 */
public class SquareRoot {
	public static void main(String[] args) {

		System.out.println("square root >> " +  get_square_root_itr(36));

		double in = 36;
		double max = in;
		double min = 0;
		System.out.println("square root >> " +  get_square_root_recursion(in, max, min));
	}

	/**find square root using iteration**/
	public static double get_square_root_itr(double in) {
		if (in < 0) throw new RuntimeException("Input should be greater than 0");

		double tolerance_percentage = 0.001;

		double resp = 0;
		double low = 0;
		double high = in;

		resp = (high + low)/2;

		while(Math.abs((in - resp*resp)/in) > tolerance_percentage) {
			if (resp*resp > in) {
				high = resp;
			} else if (resp * resp < in) {
				low = resp;
			}
			resp = (high + low)/2;
		}

		return resp;
	}

	/**find square root using recursion**/
	public static double get_square_root_recursion(double in, double max, double min) {
		double tolerance_percentage = 0.001;
		double resp = (max + min)/2;

		if (Math.abs((in - Math.pow(resp, 2))/in) > tolerance_percentage) {
			if (Math.pow(resp, 2) - in > 0) {
				max = resp;
				resp = get_square_root_recursion(in, max, min);
			} else if (Math.pow(resp, 2) - in < 0) {
				min = resp;
				resp = get_square_root_recursion(in, max, min);
			}
		}
		return resp;
	}
}
