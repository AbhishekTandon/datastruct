package datastruct.personal.sorting;

public class DutchSort {
	public static void main(String[] args) {
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

		bucketSort(arr, arr.length);
		StringBuilder buffer = new StringBuilder();
		for (Integer element: arr) {
			buffer.append(element).append(" ");
		}
		System.out.println("sorted array >> " + buffer.toString());
	}

	public static void bucketSort(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0;

		while (mid <= hi) {
			switch (a[mid]) {
				case 0:
					swap(a, lo, mid);
					lo++;
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(a, mid, hi);
					hi--;
					break;
			}
		}
	}

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
