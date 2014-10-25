package datastruct.personal.permutation;

import java.util.*;

public class CurrencyChange {
	static int QUARTER = 25;
	static int DIME = 10;
	static int NICKEL = 5;
	static int CENT = 1;

	public static void main (String[] args) {
		int amount = 100;

		List<Map<Integer, Integer>> count = get_number_of_change(amount);
		for(Map map: count) {
			System.out.println(String.format("QUARTER (%s); DIME (%s); NICKEL(%s); CENT(%s)", map.get(QUARTER), map.get(DIME), map.get(NICKEL), map.get(CENT)));
		}
	}

	public static List<Map<Integer, Integer>> get_number_of_change(int amount) {
		List<Map<Integer, Integer>> count = new ArrayList<>();
		for(int quarters = 0; quarters <= amount/QUARTER;  ++quarters) {
			for(int dimes = 0; dimes <= amount/DIME;  ++dimes) {
				for(int nickels = 0; nickels <= amount/NICKEL;  ++nickels) {
					for(int cents = 0; cents <= amount/CENT;  ++cents) {
						int totalAmount = (quarters * QUARTER) + (dimes * DIME) + (nickels * NICKEL) + (cents * CENT);
						if (totalAmount == amount) {
							Map<Integer, Integer> map = new HashMap<>();
							map.put(QUARTER, quarters);
							map.put(DIME, dimes);
							map.put(NICKEL, nickels);
							map.put(CENT, cents);
							count.add(map);
						}
					}
				}
			}
		}

		return count;
	}

}
