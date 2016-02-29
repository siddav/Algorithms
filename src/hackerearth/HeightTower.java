package hackerearth;

import java.util.Arrays;

public class HeightTower {

	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 0, 1, 8, 1 };
		int[] left = new int[a.length];
		int[] right = new int[a.length];
		int maxSoFar = 0;
		for (int i = 0; i < a.length; i++) {
			left[i] = maxSoFar;
			if (a[i] > maxSoFar) {
				maxSoFar = a[i];
			}
		}
		maxSoFar = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			right[i] = maxSoFar;
			if (a[i] > maxSoFar) {
				maxSoFar = a[i];
			}
		}
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			int min = Math.min(left[i], right[i]);
			if (min > a[i]) {
				result = result + (min - a[i]);
			}
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		System.out.println("result " + result);
	}
}
