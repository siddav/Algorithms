package ideserve;

/**
 * http://www.ideserve.co.in/learn/maximum-size-square-sub-matrix-with-all-1s
 * 
 * @author sidda
 *
 */
public class Square1s {

	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("-------------");
	}

	public static void main(String[] args) {
		Square1s s = new Square1s();
		int[][] m = { { 0, 1, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1 }, { 0, 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 1 } };
		s.printMatrix(m);
		s.maxSquares(m);
	}

	private void maxSquares(int[][] m) {
		int m1 = m.length;
		int n1 = m[0].length;
		int[][] r = new int[m.length][m[0].length];
		for (int i = 0; i < m1; i++) {
			r[i][0] = m[i][0];
		}
		for (int j = 0; j < n1; j++) {
			r[0][j] = m[0][j];
		}
		for (int i = 1; i < m1; i++) {
			for (int j = 1; j < n1; j++) {
				if (m[i][j] == 1) {
					int a = r[i - 1][j - 1];
					int b = r[i - 1][j];
					int c = r[i][j - 1];
					int min = a < b ? (a < c ? a : (b < c ? b : c)) : b < c ? b : (c < a ? c : a);
					r[i][j] = min + 1;
				} else {
					r[i][j] = 0;
				}
			}
		}
		printMatrix(r);
	}
}
