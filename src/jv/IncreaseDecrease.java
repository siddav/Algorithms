package jv;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IncreaseDecrease {

	public static void main(String[] args) {
		int arr[] = { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 };
		Arrays.sort(arr);
		System.out.println("sorted array\n");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int maxLengthSofar = 0;
		int localMax = 1;
		int index = -1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - 1 == arr[i - 1]) {
				localMax++;
				if (localMax >= maxLengthSofar) {
					maxLengthSofar = localMax;
					index = i;
				}
			} else {
				localMax = 1;
			}

		}

		System.out.println("\nmax subsequence length " + maxLengthSofar + " starting with index: " + index);

		System.out.println("----- Method 2 ------");
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i] - 1)) {
				int count = 1;
				while (set.contains(arr[i] + count)) {
					count++;
				}
				if (res < count) {
					res = count;
				}
			}
		}
		System.out.println("\nmax subsequence length " + res);
	}
}
