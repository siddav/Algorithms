package backtracking;

public class NQueen {
	static int N = 8;

	public static void main(String[] args) {
		int[] a = new int[N];
		solveNQueen(a, 0);
	}

	private static void solveNQueen(int[] q, int n) {
		if (N == n) {
			printSolution(q);
		} else {
			for (int i = 0; i < N; i++) {
				q[n] = i;
				if (isConsistent(q, n)) {
					solveNQueen(q, n + 1);
				}
			}
		}
	}

	private static boolean isConsistent(int[] q, int n) {
		for (int i = 0; i < n; i++) {
			if (q[i] == q[n])
				return false;
			if (Math.abs(q[i] - q[n]) == Math.abs(n - i))
				return false;
		}
		return true;
	}

	private static void printSolution(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int col = a[i];
			for (int j = 0; j < a.length; j++) {
				if (j == col) {
					System.out.print(" Q ");
				} else {
					System.out.print(" * ");
				}
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}

	private static boolean isValid(int[] row, int i, int j) {
		return false;
	}
}
