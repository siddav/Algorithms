package hackerearth;

import java.util.Scanner;

public class Prateek {
	public static void main(String[] args) {
		System.out.println("3831820");
		System.out.println("4426935");
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int N = scan.nextInt();
			int X = scan.nextInt();
			int f[] = new int[N];
			for (int j = 0; j < N; j++) {
				f[j] = scan.nextInt();
			}
			System.out.println(isCostContinuous(f, X));
		}
	}

	private static String isCostContinuous(int[] f, int x) {
	String NO = "NO";
	String YES = "YES";
	int sum = f[0];
	int start = 0;
	int current = 1;
	int N = f.length;
	while (current < N && start < current) {
		if (sum > x) {
			sum = sum - f[start];
			start++;
		} else if (sum == x) {
			return YES;
		} else {
			sum = sum + f[current];
			if(!(sum > x)) {
				current++;
			}
		}
	}
	if(sum == x) {
		return YES;
	}
	System.out.println("current " + current + "f[]"+ f[current] + " start " + start + " sum " + sum);
	return NO;
	}
}
