package jv;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArray {
	public static void main(String[] args) {
		int[] a = { 1, 0, 1, 1, 1, 0, 0 };
		int[] left = new int[a.length];
		left[0] = (a[0] == 0) ? -1 : 1;
		for (int i = 1; i < a.length; i++) {
			left[i] = ((a[i] == 0) ? -1 : 1) + left[i - 1];
		}
		for (int i = 0; i < left.length; i++) {
			System.out.print(left[i] + " ");
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxSize = -1;

	}
}
