package ideserve;

public class Rotate90 {
	public void rotate90(int[][] a) {
		int n = a.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int start = layer;
			int end = n - layer - 1;
			for (int i = start; i < end; i++) {
				int offset = i - start;
				int top = a[start][i];
				a[start][i] = a[end - offset][start];
				a[end - offset][start] = a[end][end - offset];
				a[end][end - offset] = a[i][end];
				a[i][end] = top;
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		Rotate90 r = new Rotate90();
		int[][] a = { { 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 } };
		r.rotate90(a);
	}
}
