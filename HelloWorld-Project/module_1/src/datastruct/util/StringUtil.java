package datastruct.util;

public class StringUtil {

	public static void swap(char[] a, int i, int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
