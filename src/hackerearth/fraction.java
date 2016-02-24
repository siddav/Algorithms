package hackerearth;

import java.util.Scanner;

public class fraction {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		printFraction(arr);
	}

	private static void printFraction(int[] arr) {
		int l = arr.length;
		float p = 0;
		float n = 0;
		float z = 0;
		for (int i = 0; i < l; i++) {
			if (arr[i] > 0) {
				p++;
			} else if (arr[i] < 0) {
				n++;
			} else {
				z++;
			}
		}
		System.out.println(p);
		System.out.println(n);
		System.out.println(z);
		System.out.printf("%.5f", p > 0 ? p / l : 0);
		System.out.printf("%.5f", n > 0 ? n / l : 0);
		System.out.printf("%.5f", z > 0 ? z / l : 0);
	}
}
