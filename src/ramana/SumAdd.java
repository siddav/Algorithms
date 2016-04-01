package ramana;

import java.util.HashMap;
import java.util.Map;

public class SumAdd {

	public static void main(String[] args) {
		int[] a = { 3, 1, 6, 4, 2, 8, 9, 5, 0 };
		int sum = 5;
		pairSum(a, sum);
	}

	private static void pairSum(int[] a, int sum) {
		Map<Integer, Integer> pairSum = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			pairSum.put(a[i], 1);
		}
		for (int i = 0; i < a.length; i++) {
			int k = sum - a[i];
			if (pairSum.containsKey(k)) {
				System.out.println(a[i] + ", " + k);
				// To remove duplicates from output uncomment below
				// lines
				/*
				 * pairSum.remove(k); pairSum.remove(a[i]);
				 */
			}
		}
	}
}
