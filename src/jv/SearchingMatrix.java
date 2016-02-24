package jv;

public class SearchingMatrix {
	public void search(int[][] a, int search) {
		int row = a.length;
		int column = a[0].length;
		int i = 0;
		int j = column - 1;
		int start = a[i][j];
		while (j >= 0 && i < row) {
			if (search == a[i][j]) {
				System.out.println("index found at i,j" + i + ", " + j);
				return;
			} else if (search > a[i][j]) {
				i++;
			} else {
				j--;
			}
		}
		System.out.println("cannot find element");
	}

	public static void main(String[] args) {
		int[][] a = { { 15, 20, 40, 85 }, { 20, 35, 80, 95 }, { 30, 55, 95, 105 }, { 40, 80, 100, 120 } };
		SearchingMatrix m = new SearchingMatrix();
		m.search(a, 195);
	}
}
