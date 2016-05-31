package hackerrank;

import java.util.Scanner;

public class InsertionSort {
	public static void insertIntoSorted(int[] ar) {
		// Fill up this function
		int n = ar.length;
		int unSorted = ar[n - 1];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] > unSorted) {
				for (int j = n - 2; j >= i; j--) {
					ar[j + 1] = ar[j];
					printArray(ar);
				}
				ar[i] = unSorted;
				printArray(ar);
				break;
			}
		}
	}

	public static void insertionSortPart2(int[] ar) {
		// Fill up the code for the required logic here
		// Manipulate the array as required
		// The code for Input/Output is already provided
		int n = ar.length;
		int shifts = 0;
		for (int i = 1; i < n; i++) {
			int unSorted = ar[i];
			int j = i - 1;
			while (j >= 0 && unSorted < ar[j]) {
				ar[j + 1] = ar[j];
				shifts++;
				j--;
			}
			ar[j + 1] = unSorted;
		}
		System.out.println(shifts);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		// insertIntoSorted(ar);
		insertionSortPart2(ar);
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
