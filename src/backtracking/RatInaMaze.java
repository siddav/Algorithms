package backtracking;

public class RatInaMaze {
	public static void main(String[] args) {
		int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		solveMaze(a);
	}

	private static void solveMaze(int[][] a) {
		int[][] sol = new int[a.length][a[0].length];

		if (!solveMazeUtil(a, 0, 0, sol)) {
			System.out.println("no solution");
		} else {
			printSolution(sol);
		}
	}

	/*
	 * A recursive utility function to solve Maze problem
	 */
	static int N = 4;

	static boolean solveMazeUtil(int maze[][], int x, int y,
                       int sol[][])
 {
     // if (x,y is goal) return true
     if (x == N - 1 && y == N - 1)
     {
         sol[x][y] = 1;
         return true;
     }

     // Check if maze[x][y] is valid
     if (isValid(maze, x, y) == true)
     {
         // mark x,y as part of solution path
         sol[x][y] = 1;

         /* Move forward in x direction */
         if (solveMazeUtil(maze, x + 1, y, sol))
             return true;

         /* If moving in x direction doesn't give
            solution then  Move down in y direction */
         if (solveMazeUtil(maze, x, y + 1, sol))
             return true;

         /* If none of the above movements work then
            BACKTRACK: unmark x,y as part of solution
            path */
         sol[x][y] = 0;
         return false;
     }
     return false;
 }

	private static boolean isValid(int[][] a, int i, int j) {
		return (i >= 0 && i < a.length && j >= 0 && j < a[0].length && a[i][j] != 0);
	}

	private static void printSolution(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}
}
