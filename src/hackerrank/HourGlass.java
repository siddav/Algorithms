package hackerrank;

import java.util.Scanner;

public class HourGlass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] a = new int[6][6];
		int m = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 && scan.hasNextInt(); j++) {
				a[i][j] = scan.nextInt();
				;
			}
		}
		System.out.println("maxsum " + hourGlassMaxSum(a));
	}

	private static int hourGlassMaxSum(int[][] a) {
		int maxSum = Integer.MIN_VALUE;
		int i = 0, j = 0;
		while (i <= 3) {
			int tl = a[i][j];
			int t = a[i][j + 1];
			int tr = a[i][j + 2];
			int m = a[i + 1][j + 1];
			int bl = a[i + 2][j];
			int b = a[i + 2][j + 1];
			int br = a[i + 2][j + 2];
			int sum = tl + t + tr + m + bl + b + br;
			if (sum > maxSum) {
				maxSum = sum;
			}
			if (j == 3) {
				j = 0;
				i++;
			} else {
				j++;
			}
		}
		return maxSum;
	}
}
