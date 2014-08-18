package datastruct.personal.sorting;

public class Sorting {


	public static void main(String[] args) {
		System.out.println("output of the quick sorting");
		String str = "some string that is going to be sorted";
		char[] chars = str.toCharArray();
		Sorting algo = new Sorting();
		algo.quickSort(chars, 0, chars.length -1);

		for (char c: chars) System.out.println(c);

		/**
		 * Merge sorting algorithm
		 */
		System.out.println("output of the merge sorting");
		String str2 = "abdzdfrg";
		char[] list = str2.toCharArray();
		char[] aux = new char[list.length];
		algo.mergeSort(list, aux, 0, list.length - 1);

		for (char c: list) System.out.println(c);

		/**
		 * Insertion sort
		 */
		System.out.println("out of the insertion sort");
		String str3 = "zefaxywhinmok";
		char[] insertList = str3.toCharArray();

		algo.insertionSort(insertList, 0, insertList.length -1);
		for (char c: insertList) System.out.println(c);
	}

	public void quickSort(char[] chars, int low, int high) {
		if (low >= high) return;

		int partition = partition(chars, low, high);
		quickSort(chars, low, partition -1);
		quickSort(chars, partition + 1, high);
	}

	public void exchange(char[] a, int i, int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public int partition(char[] a, int low, int high) {
		char pivot = a[high];
		int i = low - 1;

		/**
		 * i - keeps pointer to char that are less than pivot
		 * j - is increments to find elements and compare that to pivot
		 * a[j] < pivot - swap this move this element to left
		 */
		for (int j = low; j<= high; j++ ){
			if (a[j] < pivot) {
				i++;
				exchange(a, i, j);
			}
		}
		exchange(a, i+1, high);
		return i+1;
	}

	public void mergeSort(char[] a, char[] aux, int low, int high) {

		if (low >= high) return;

		int mid = low + (high - low)/2;
		mergeSort(a, aux, low, mid);
		mergeSort(a, aux, mid+1, high);

		// merge operation
		merge(a, aux, low, mid, high);
	}

	public void merge(char[] a, char[] aux, int low, int mid, int high) {
		for (int i = low; i <= high; i++) aux[i] = a[i];

		int indxLow  = low;
		int  indxHigh = mid +1;
		int i = low;
		while((indxLow <= mid) || (indxHigh <= high)) {
			if (indxLow <= mid && indxHigh <= high && aux[indxLow] <= aux[indxHigh]) a[i++] = aux[indxLow++];
			else if (indxLow <= mid && indxHigh <= high && aux[indxLow] > aux[indxHigh]) a[i++] = aux[indxHigh++];
			else if (indxHigh > high) a[i++] = aux[indxLow++];
			else if (indxLow > mid) a[i++] = aux[indxHigh++];
		}
	}

	public void insertionSort(char[] a, int low, int high) {
		for (int i = 0; i < a.length; i++) {
			//inserting the elements to left if they are small
			int k;
			for (k = i; k > 0 && (a[k-1] > a[k]); k-- ) {
					exchange(a, k, k-1); //
			}
		}
	}
}
