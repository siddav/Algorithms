package dailycoding;

/**
 * This problem was asked by Google.
 * 
 * Given an array of integers where every integer occurs three times except for
 * one integer, which only occurs once, find and return the non-duplicated
 * integer.
 * 
 * For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13],
 * return 19.
 * 
 * Do this in O(N) time and O(1) space.
 * 
 * @author vsidda
 *
 */
public class _40_leftover {
	public static void main(String[] args) {
		int[] a = { 13, 19, 13, 13 };
		System.out.println("" + getOddManOut(a));
	}

	private static int getOddManOut(int[] a) {
		int[] bits = new int[32];
		for (int i = 0; i < a.length; i++) {
			int num = a[i];
			for (int j = 0; j < 32; j++) {
				int bit = (num >> j) & 1;
				bits[j] = (bits[j] + bit) % 3;
			}
		}
		int result = 0;
		for (int i = 0; i < bits.length; i++) {
			if (bits[i] == 1) {
				result = (int) (result +  Math.pow(2, i));
			}
		}
		return result;
	}
}
