package backtracking;

public class KnightsProblem {

	public static void main(String[] args) {
		solveKT();
	}

	private static void solveKT() {
		int[][] sol = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				sol[i][j] = -1;
			}
		}

		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		sol[0][0] = 0;
		if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
			System.out.println("solution doesnt exist");
		} else {
			printSolution(sol);
		}
	}

	private static void printSolution(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static boolean solveKTUtil(int i, int j, int move, int[][] sol, int[] xMove, int[] yMove) {
		if (move == 64) {
			return true;
		}
		for (int k = 0; k < 8; k++) {
			int next_x = i + xMove[k];
			int next_y = j + yMove[k];
			if (isValid(next_x, next_y, sol)) {
				sol[next_x][next_y] = move;
				if (solveKTUtil(next_x, next_y, move + 1, sol, xMove, yMove)) {
					return true;
				} else {
					sol[next_x][next_y] = -1; // backtracking
				}
			}
		}
		return false;
	}

	private static boolean isValid(int next_x, int next_y, int[][] sol) {
		return (next_x >= 0 && next_x < 8 && next_y >= 0 && next_y < 8 && (sol[next_x][next_y] == -1));
	}
}
