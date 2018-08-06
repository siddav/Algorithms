package dailycoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This problem was recently asked by Google.
 * 
 * Given a list of numbers and a number k, return whether any two numbers from
 * the list add up to k.
 * 
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is
 * 17.
 * 
 * Bonus: Can you do this in one pass?
 * 
 * 
 * @author sidda
 *
 */
public class _1_sum {
	/*
	 * o(N) time + o(N) space
	 */
	static boolean solve_mine(int[] a, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				return true;
			}
			int x = k - a[i];
			map.put(x, 1);
		}
		return false;
	}

	/*
	 * O(N^2) space
	 */
	static boolean solve_brute(int[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == k) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * o(NlogN) {sort} + O(NlogN) {binary search for n elements} ==> O(NlogN)
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	static boolean solve_sort(int[] a, int k) {
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (Arrays.binarySearch(a, k - a[i]) > -1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = { 10, 15, 3, 7 };
		int sum = 17;
		System.out.println(solve_mine(a, sum));
		System.out.println(solve_brute(a, sum));
		System.out.println(solve_sort(a, sum));
		System.out.println("---------------");
		sum = 12;
		System.out.println(solve_mine(a, sum));
		System.out.println(solve_brute(a, sum));
		System.out.println(solve_sort(a, sum));
	}
}
