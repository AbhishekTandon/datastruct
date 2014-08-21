package datastruct.personal.permutation;

import java.util.*;

// Different combinations using the elements of a Set
public class CreateSubset {

	static Integer[] list = new Integer[5];


	public static void main(String[] main) {

		// creating a set
		for (int i = 0; i < list.length; i++) list[i] = new Integer(i);

		List<List<Integer>> subSets = new ArrayList<>();

		for (int i = 0; i < list.length; i++) {
			List<List<Integer>> auxSubSets = new ArrayList<>();
			if (subSets.size() == 0) {
				auxSubSets = createSubset(new ArrayList<Integer>(), i);
			} else {
				for (int k = 0; k < subSets.size(); k++) {
					auxSubSets.addAll(createSubset(subSets.get(k), i));
				}
			}

			subSets = auxSubSets;
		}


		System.out.println("number of subsets >>" + subSets.size());
		for (List<Integer> set: subSets) {
			StringBuilder buffer = new StringBuilder();
			for (Integer num: set) buffer.append(num.toString() + " ");
			System.out.println(String.format("printing subset >> {%s}", buffer.toString()));
		}

	}

	public static List<List<Integer>> createSubset(List<Integer> set, Integer indx) {
		List<List<Integer>> subset = new ArrayList<>();

		// clone 1 of the subset
		List<Integer> list1 = new ArrayList<>();
		for (Integer num : set) list1.add(num);
		list1.add(list[indx]);

		// clone 2 of the subset
		List<Integer> list2 = new ArrayList<>();
		for (Integer num : set) list2.add(num);

		// adding clones to the subset
		subset.add(list1);
		subset.add(list2);

		return subset;
	}
}
