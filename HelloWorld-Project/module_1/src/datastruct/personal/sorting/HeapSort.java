package datastruct.personal.sorting;

public class HeapSort {
	public static void main(String[] args) {
		String str = "something string to sortz";
		char[] a = str.toCharArray();
		mergeSort(a);
	}


	public static void mergeSort(char[] a) {
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

		StringBuilder buffer = new StringBuilder();
		for(int i = 0; i < aux.length; i++) {
			buffer.append(aux[i]);
		}

		System.out.println(String.format("displaying the sorted string {%s}", buffer.toString()));

	}

	public static int put(char[] a, int index, char value) {
		a[++index] = value;
		return index;
	}

	public static void balance_up_heap(char[] a, int endIndx) {
		int parentIndx = endIndx/2;
		if (parentIndx > 0 && a[parentIndx] < a[endIndx]) {
			swap(a, parentIndx, endIndx);
			balance_up_heap(a, parentIndx);
		}
	}


	/**
	 * TODO:
	 * 1. remove topmost element in the HEAP
	 * 2. place the last index of the HEAP with the topmost
	 * 3. balance_down_heap
	 */
	public static int pop(char[] a, int endIndex) {

		return --endIndex;
	}

	public static void swap (char[] a, int i, int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static boolean isEmpty(char[] a, int indx) {
		return a[indx] == '\u0000';
	}

	public static int leftChild(int indx) {
		return (2*indx);
	}

	public static int rightChild(int indx) {
		return (2*indx + 1);
	}
}
