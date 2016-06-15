package hackerrank;

import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		quickSort(ar);
	}
// 4 5 3 7 2
	/**
	 *  4 5 3 7 2
	 *  4 2 3 7 5
	 *  1 2 3 4
	 *  4 3 2 1
	 * @param ar
	 */
	private static void quickSort(int[] ar) {
		int n = ar.length;
		int pivot = ar[0];
		int i = 1, j = n - 1;
		
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
