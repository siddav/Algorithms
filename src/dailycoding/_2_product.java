package dailycoding;

import util.utils;

/**
 * This problem was asked by Uber.
 * 
 * Given an array of integers, return a new array such that each element at
 * index i of the new array is the product of all the numbers in the original
 * array except the one at i.
 * 
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would
 * be [2, 3, 6].
 * 
 * Follow-up: what if you can't use division?
 * 
 * @author sidda
 *
 */
public class _2_product {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		utils.printArray(solve_mine(a));
		utils.printArray(solve_no_division(a));
	}

	/**
	 * o(n) + o(n) time
	 * 
	 * @param a
	 * @return
	 */
	private static int[] solve_mine(int[] a) {
		int[] b = new int[a.length];
		int product = 1;
		for (int j = 0; j < a.length; j++) {
			product = product * a[j];
		}
		for (int i = 0; i < a.length; i++) {
			b[i] = product / a[i];
		}
		return b;
	}

	private static int[] solve_no_division(int[] a) {
		int[] b = new int[a.length];
		int[] left = new int[a.length];
		int[] right = new int[a.length];
		left[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			left[i] = left[i - 1] * a[i];
		}

		right[a.length - 1] = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * a[i];
		}

		for (int i = 1; i < a.length - 1; i++) {
			b[i] = left[i - 1] * right[i + 1];
		}
		b[0] = right[1];
		b[a.length - 1] = left[a.length - 2];
		return b;
	}

}
