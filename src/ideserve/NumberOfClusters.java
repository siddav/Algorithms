package ideserve;

public class NumberOfClusters {

	public int findNumberOfClusters(int[][] matrix) {
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int rows = matrix.length;
		int columns = matrix[0].length;
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] == 1 && visited[i][j] == false) {
					count++;
					doDFS(matrix, i, j, visited);
				}
			}
		}
		return count;
	}

	int[] offsets = { -1, 0, +1 };

	private void doDFS(int[][] matrix, int i, int j, boolean[][] visited) {
		if (visited[i][j]) {
			return;
		}
		visited[i][j] = true;
		for (int m = 0; m < offsets.length; m++) {
			int xOffset = offsets[m];
			for (int n = 0; n < offsets.length; n++) {
				int yOffset = offsets[n];
				if (xOffset == 0 && yOffset == 0) {
					continue;
				}
				if (neighbourExists(matrix, i + xOffset, j + yOffset)) {
					doDFS(matrix, i + xOffset, j + yOffset, visited);
				}
			}
		}
	}

	private boolean neighbourExists(int[][] matrix, int i, int j) {
		if (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length) {
			if (matrix[i][j] == 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		NumberOfClusters n = new NumberOfClusters();
		int[][] matrix = { { 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 0, 1, 1 }, };
		System.out.println(n.findNumberOfClusters(matrix));
	}
}
