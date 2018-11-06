package ds;

import java.util.Scanner;

public class Bob {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = scan.nextInt();
		}
		System.out.println(printSum(a));
		scan.close();
	}

	private static int printSum(int[] a) {
		int global = 0;
		for (int i = 0; i < a.length; i++) {
			int res = 0;
			int current = a[i];
			for (int j = i + 1; j < a.length; j++) {
				System.out.println(current);
				res += current;
				current = current | a[j];					
			}
			res += current;
			global = global + res;
		}
		return global;
	}
}
