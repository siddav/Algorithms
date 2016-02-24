package jv;

public class Searching {

	public int rotatedBinarySearch(int[] a, int search, int left, int right) {
		int middle = left + (right - left) / 2;
		if (a[middle] == search) {
			return middle;
		}
		if (left > right) {
			return -1;
		}
		// left is normally ordered
		if (a[middle] > a[left]) {
			if (search >= a[left] && search <= a[middle]) {
				return rotatedBinarySearch(a, search, left, middle - 1);
			} else {
				return rotatedBinarySearch(a, search, middle + 1, right);
			}
		} else if (a[middle] < a[right]) {
			if (search >= middle && search <= a[right]) {
				return rotatedBinarySearch(a, search, middle + 1, right);
			} else {
				return rotatedBinarySearch(a, search, left, middle - 1);
			}
		} else if (a[middle] == a[left]) {
			if (a[middle] != right) {
				return rotatedBinarySearch(a, search, middle + 1, right);
			} else {
				int result = rotatedBinarySearch(a, search, left, middle - 1);
				if (result == -1) {
					return rotatedBinarySearch(a, search, middle + 1, right);
				} else {
					return -1;
				}
			}
		}
		return -1;
	}

	public int binarySearch(int[] a, int search) {
		int index = -1;
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (a[middle] == search) {
				index = middle;
				break;
			} else if (search < middle) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return index;
	}

	public int binarySearch(int[] a, int search, int low, int high) {
		int index = -1;
		int middle = low + (high - low) / 2;
		if (a[middle] == search) {
			return middle;
		} else if (a[middle] > search) {
			return binarySearch(a, search, low, middle - 1);
		} else if (a[middle] < search) {
			return binarySearch(a, search, middle + 1, high);
		}
		return index;
	}

	public static void main(String[] args) {
		int[] a = { 1, 34, 36, 79, 84, 90 };
		Searching s = new Searching();
		System.out.println("found the number at index " + s.binarySearch(a, 84));
		System.out.println("found the number at index " + s.binarySearch(a, 184));
		a = new int[] { 36, 79, 84, 90, 1, 34 };
		System.out.println(s.rotatedBinarySearch(a, 1, 0, a.length - 1));
	}
}
