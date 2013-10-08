package week3.opdracht33;

public class QuickSort<T extends Comparable<T>> implements Comparable<T> {

	public void quickSort(T[] a) {
		if (a.length <= 1) {
			return;
		}
		quickSort(a, 0, a.length - 1);
	}

	private void quickSort(T[] a, int low, int high) {
		int ip = (low + high) / 2;

		if (low < high) {
			swap(a, low, ip);
			int m = low;
			
			for (int j = low + 1; j <= high; j++) {
				if (a[j].compareTo(a[low]) < 0) {
					m++;
					swap(a, m, j);
				}
			}
			swap(a, low, m);
			
			quickSort(a, low, m - 1);
			quickSort(a, m + 1, high);
		}
	}

	private void swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	@Override
	public int compareTo(T o) {
		return this.compareTo(o);
	}

	public static void main(String[] args) {
		QuickSort<Integer> qs = new QuickSort<Integer>();

		Integer[] ia = new Integer[]{45, 65, 34, 4, 30, 22, 82};

		System.out.println("START:");
		for (Integer i : ia)
			System.out.print(i + " ");

		qs.quickSort(ia);

		System.out.println("\n" + "END:");
		for (Integer i : ia)
			System.out.print(i + " ");

	}

}