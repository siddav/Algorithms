package jv;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				 };
		SpiralMatrix s = new SpiralMatrix();
		s.print(a);
	}

	private void print(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		int x = 0;
		int y = 0;
		while (m > 0 && n > 0) {
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					System.out.print(a[x][y++] + " ");
				}
				break;
			} else if (n == 1) {
				for (int i = 0; i < m; i++) {
					System.out.print(a[x++][y] + " ");
				}
				break;
			}
			for (int i = 0; i < n - 1; i++) {
				System.out.print(a[x][y++] + " ");
			}
			for (int i = 0; i < m - 1; i++) {
				System.out.print(a[x++][y] + " ");
			}

			for (int i = n - 1; i > 0; i--) {
				System.out.print(a[x][y--] + " ");
			}

			for (int i = m - 1; i > 0; i--) {
				System.out.print(a[x--][y] + " ");
			}
			m = m - 2;
			n = n - 2;
			//System.out.println("loop" + x +" : " + y);
			x++;
			y++;
		}
	}
}
