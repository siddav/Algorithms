package jv;

public class CountSort {

	public static void main(String[] args) {
		int[] a = { 1, 4, 1, 2, 7, 5, 2 };
		int k = 10;
		int[] c = new int[k];
		for (int i = 0; i < a.length; i++) {
			c[a[i]] = c[a[i]] + 1;
		}
		for (int i = 1; i < c.length; i++) {
			c[i] = c[i] + c[i - 1];
		}
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
           b[c[a[i]] - 1] = a[i];
           c[a[i]] = c[a[i]] - 1;
		}

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}
}
