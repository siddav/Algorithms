package dailycoding;

import java.util.Arrays;

/**
 * This problem was asked by Airbnb.
 * 
 * Given a list of integers, write a function that returns the largest sum of
 * non-adjacent numbers. Numbers can be 0 or negative.
 * 
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5,
 * 1, 1, 5] should return 10, since we pick 5 and 5.
 * 
 * Follow-up: Can you do this in O(N) time and constant space?
 * 
 * @author vsidda
 *
 */
public class _9_sum_nonadjacent_numbers {
	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 2, 5 };
		System.out.println("max so far " + findNonAdjacentMax_NAIVE(a));
		System.out.println("max so far recursive " + findNonAdjacentMax_RECURSIVE(a));
		System.out.println("max so far DP " + findNonAdjacentMax_RECURSIVE_DP(a));
		System.out.println("max so far iterative " + findNonAdjacentMax_ITERATIVE_memo(a));
		System.out.println("max so far with two variables " + findNonAdjacentMax_twoVariables(a));
	}

	private static int findNonAdjacentMax_NAIVE(int[] a) {
		if (a.length == 0) {
			return 0;
		}
		int max_so_far = Math.max(a[0], a[1]);
		for (int i = 1; i < a.length; i++) {
			for (int inc = 2; i + inc < a.length; inc++) {
				int sum = a[i];
				int j = inc;
				while (i + j < a.length) {
					sum += a[j];
					j = j + inc;
				}
				if (sum > max_so_far) {
					max_so_far = sum;
				}
			}
		}
		return max_so_far;
	}

	/**
	 * O(2 power n)
	 * 
	 * @param a
	 * @return
	 */
	private static int findNonAdjacentMax_RECURSIVE(int[] a) {
		return findNonAdjacent_RECURSIVE_helper(a, 0);
	}

	private static int findNonAdjacent_RECURSIVE_helper(int[] a, int length) {
		if (length >= a.length) {
			return 0;
		}
		return Math.max(a[length] + findNonAdjacent_RECURSIVE_helper(a, length + 2),
				findNonAdjacent_RECURSIVE_helper(a, length + 1));
	}

	/**
	 * using DP/memo
	 */
	private static int findNonAdjacentMax_RECURSIVE_DP(int[] a) {
		int[] mem = new int[a.length + 1];
		Arrays.fill(mem, -1);
		return findNonAdjacent_RECURSIVE_helper_DP(a, 0, mem);
	}

	private static int findNonAdjacent_RECURSIVE_helper_DP(int[] a, int length, int[] mem) {
		if (length >= a.length) {
			return 0;
		}
		if (mem[length] != -1) {
			return mem[length];
		}
		int result = Math.max(a[length] + findNonAdjacent_RECURSIVE_helper(a, length + 2),
				findNonAdjacent_RECURSIVE_helper(a, length + 1));
		mem[length] = result;
		return result;
	}

	/**
	 * bottom up thinking similar to memo instead of recursive
	 */
	private static int findNonAdjacentMax_ITERATIVE_memo(int[] a) {
		if (a.length == 0) {
			return 0;
		}
		if (a.length == 1) {
			return a[0];
		}
		if (a.length == 2) {
			return Math.max(a[0], a[1]);
		}

		int[] mem = new int[a.length];
		mem[0] = a[0];
		mem[1] = a[1];
		for (int i = 2; i < a.length; i++) {
			mem[i] = Math.max(a[i] + mem[i - 2], mem[i - 1]);
		}
		return mem[a.length - 1];
	}

	/**
	 * just with two variables
	 */
	private static int findNonAdjacentMax_twoVariables(int[] a) {
		if (a.length == 0) {
			return 0;
		}
		if (a.length == 1) {
			return a[0];
		}
		if (a.length == 2) {
			return Math.max(a[0], a[1]);
		}
		int max_excluding_last = a[0];
		int max_including_last = a[1];

		for (int i = 2; i < a.length; i++) {
			int prev_including_last = max_including_last;
			max_including_last = Math.max(a[i] + max_excluding_last, max_including_last);
			max_excluding_last = prev_including_last;
		}
		return Math.max(max_including_last, max_excluding_last);
	}
}
