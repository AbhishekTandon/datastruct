package datastruct.personal.sorting;

/**
 * Implement insert and removing elements from HEAP
 */
public class HeapSort {
	public static void main(String[] args) {
		String str = "something string to sortz";
		char[] a = str.toCharArray();
		heap_sort(a);
	}


	// Place characters inside a[] into HEAP
	public static void heap_sort(char[] a) {
		int length = a.length + 1;
		char[] aux = new char[length + 1];

		int endIndex = 0;
		for (int k = 0; k < a.length; k++) {
			if (endIndex == 0) endIndex = put(aux, endIndex, a[k]);
			else {
				// TODO: consolidate this one into  method insert_into_heap
				endIndex = put(aux, endIndex, a[k]);
				balance_up_heap(aux, endIndex);
			}
		}

		System.out.println("printing endIndex after pushing all values >>" + endIndex);

		StringBuilder buffer = new StringBuilder();
		for(int i = 1; i < aux.length; i++) { // a[0] is empty
			buffer.append(aux[i]);
		}

		System.out.println(String.format("displaying the sorted string {%s}", buffer.toString()));

		while(endIndex > 0) endIndex  = pop(aux, endIndex);

	}

	public static int put(char[] a, int endIndex, char value) {
		a[++endIndex] = value;
		return endIndex;
	}

	public static int get_max_child_index(char[] a, int endIndex, int parentIndex) {
		char leftChild, rightChild;
		int leftChildIndex = leftChild(parentIndex);
		int rightChildIndex = rightChild(parentIndex);

		if (leftChildIndex <= endIndex && rightChildIndex <= endIndex) {
			leftChild = a[leftChildIndex];
			rightChild = a[rightChildIndex];
			if (leftChild > rightChild) return leftChildIndex;
			else return rightChildIndex;
		} else if (leftChildIndex <= endIndex) {
			return leftChildIndex;
		} else if (rightChildIndex <= endIndex) {
			return rightChildIndex;
		} else return -1;
	}

	/**
	 * TODO:
	 * 1. remove topmost element in the HEAP
	 * 2. place the last index of the HEAP with the topmost
	 * 3. balance_down_heap
	 */
	public static int pop(char[] a, int endIndex) {
		char max = '\u0000';
		if (endIndex == 0) {
			throw new RuntimeException("No more entries in array");
		} else if (endIndex == 1) {
			max  = a[1];
		} else if (endIndex > 1) {
			max = a[1];
			a[1] = a[endIndex];
			balance_down_heap(a, 1, endIndex);
		}

		System.out.println("poping element from priority queue >> " + max + " endIndex >>" + endIndex);
		return --endIndex;
	}

	public static void balance_up_heap(char[] a, int endIndx) {
		int parentIndx = endIndx/2;
		if (parentIndx > 0 && a[parentIndx] < a[endIndx]) {
			swap(a, parentIndx, endIndx);
			balance_up_heap(a, parentIndx);
		}
	}

	public static void balance_down_heap(char[] a, int parentIndx, int endIndex) {
		if (rightChild(parentIndx) <= endIndex || leftChild(parentIndx) <= endIndex) {
			int indexToSwap = get_max_child_index(a, endIndex, parentIndx);
			swap(a, parentIndx, indexToSwap);
			balance_down_heap(a, indexToSwap, endIndex);
		}
	}

	public static void swap (char[] a, int i, int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static int leftChild(int indx) {
		return (2*indx);
	}

	public static int rightChild(int indx) {
		return (2*indx + 1);
	}
}
