package datastruct.personal.permutation.dynamic.programming;

/**
 * Refer dynamic programming approach here
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 */
public class CuttingRod {
	static int max_price = 0;
	static int price[] = {1, 5, 8, 9, 10, 17, 17, 18};
	static int rod_len[] = {1, 2, 3, 4, 5, 6, 7, 8};

	public static void main(String[] args) {
		int max_val =  get_value(rod_len.length);
		System.out.println("max price >> " + max_val);
	}

	static int get_value(int length) {
		if (length <= 0) return 0;
		int max = 0;

		for(int i = 0; i < rod_len.length; i++) {
			if (rod_len[i] <= length) {
				int new_length = length - rod_len[i];
				max = Math.max(max, price[i] + get_value(new_length));
//				max_price = Math.max(max_price, max);
			} else {
				return max;
			}
		}

		return max;
	}
}
