package sorting;

public class SelectionSort {
	private void sort(int[] a) {
		int n = a.length;
		
		int minIndex = 0;
		for (int i = 0; i < n; i++) {
			int min = a[i];
			for (int j = i + 1; j < n; j++) {
				if (min > a[j]) {
					min = a[j];
					minIndex = j;
				}
			}			
			a[minIndex] = a[i];
			a[i] = min;			
		}
	}

	private void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] a = { 3, 5, 16, 7, 9, 10, 6 };
		SelectionSort s = new SelectionSort();
		s.printArray(a);
		s.sort(a);
		s.printArray(a);
	}
}
