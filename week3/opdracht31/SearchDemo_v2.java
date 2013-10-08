package week3.opdracht31;

import java.util.Arrays;

public class SearchDemo_v2<T> {
	void showArray(Object[] a) {
		int len = a.length;

		for (int i = 0; i < len; i++) {
			System.out.print("" + a[i]);
			if (i < len - 1)
				System.out.print(',');
			else
				System.out.println();
		}
	}

	int sequentialSearch(T[] a, T x) {
		int i = 0;
		int high = a.length - 1;

		while (i <= high) {
			if (a[i].equals(x))
				return i;
			i++;
		}

		return -1;
	}

	int binarySearch(Comparable<T>[] a, T x) {
		return binarySearch(a, 0, a.length - 1, x);
	}

	int binarySearch(Comparable<T>[] a, int low, int high, T x) {
		int mid = (low + high) / 2;

		if (low > high)
			return -1;
		if (a[mid].compareTo(x) < 0)
			return binarySearch(a, mid + 1, high, x);
		else if (a[mid].compareTo(x) > 0)
			return binarySearch(a, mid - 1, mid - 1, x);
		else
			return mid;
	}

	public static void main(String[] args) {
		SearchDemo_v2<Integer> sd1 = new SearchDemo_v2<Integer>();

		Integer[] ia = new Integer[] { 45, 65, 34, 82, 30, 22 };

		Arrays.sort(ia);
		sd1.showArray(ia);

		int search = 83;

		int i = sd1.binarySearch(ia, search);
		if (i != -1)
			System.out.println(search + " is on position: " + i	+ " in the array");
		else
			System.out.println(search + " is not in the array");
	}
}
