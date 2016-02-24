package jv;

public class Sortings {
	public void bubbleSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		printArray(a);
	}

	public void insertionSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = a[i];
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = temp;
			}
		}
		printArray(a);
	}

	public void mergeSort(int[] a) {
		if (a != null) {
			a = doMergeSort(a, 0, a.length - 1);
			printArray(a);
		}
	}

	private int[] doMergeSort(int[] a, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			int leftArray[] = doMergeSort(a, left, middle);
			int rightArray[] = doMergeSort(a, middle + 1, right);
			int[] result = merge(leftArray, rightArray);
			return result;
		} else {
			return new int[] { a[left] };
		}
	}

	private int[] merge(int[] a, int[] b) {
		if (a == null && b == null) {
			return null;
		}
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		int n = a.length + b.length;
		int c[] = new int[n];
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}
		while (i < a.length) {
			c[k++] = a[i++];
		}
		while (j < b.length) {
			c[k++] = b[j++];
		}
		return c;
	}

	public void quickSort(int[] a) {
		doQuickSort(a, 0, a.length - 1);
		printArray(a);
	}

	  private void doQuickSort(int[] a, int low, int high) {
		    int i = low, j = high;
		    // Get the pivot element from the middle of the list
		    int pivot = a[low + (high-low)/2];

		    // Divide into two lists
		    while (i <= j) {
		      // If the current value from the left list is smaller then the pivot
		      // element then get the next element from the left list
		      while (a[i] < pivot) {
		        i++;
		      }
		      // If the current value from the right list is larger then the pivot
		      // element then get the next element from the right list
		      while (a[j] > pivot) {
		        j--;
		      }

		      // If we have found a values in the left list which is larger then
		      // the pivot element and if we have found a value in the right list
		      // which is smaller then the pivot element then we exchange the
		      // values.
		      // As we are done we can increase i and j
		      if (i <= j) {
		        exchange(a, i, j);
		        i++;
		        j--;
		      }
		    }
		    // Recursion
		    if (low < j)
		    	doQuickSort(a, low, j);
		    if (i < high)
		    	doQuickSort(a, i, high);
		  }


	public int partition(int[] a, int left, int right) {
		int pivot = a[(left + right) / 2];
		while (left <= right) {
			while (a[left] <= pivot) {
				left++;
			}
			while (a[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}

	private void exchange(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void printArray(int[] a) {
		if (a == null) {
			System.out.println("array is null");
			return;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {

		Sortings s = new Sortings();
		System.out.println("----bubble sort ------");
		int[] a = { 25, 23, 12, 9, 76, 89, 100, 34 };
		s.bubbleSort(a);

		System.out.println("\n----insertion sort ------");
		a = new int[] { 25, 23, 12, 9, 76, 89, 100, 34 };
		s.insertionSort(a);

		System.out.println("\n----merge sort ------");
		a = new int[] { 25, 23, 12, 9, 76, 89, 100, 34 };
		s.mergeSort(a);

		System.out.println("\n----quick sort ------");
		a = new int[] { 25, 23, 12, 9, 76, 89, 100, 34 };
		s.quickSort(a);
	}

}
