package ideserve;

public class MinEditDistance {
	public int findEditDistance(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return -1;
		}
		int rows = s1.length() + 1;
		int columns = s2.length() + 1;
		int[][] distanceTable = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (i == 0) {
					distanceTable[i][j] = j;
				} else if (j == 0) {
					distanceTable[i][j] = i;
				} else {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						distanceTable[i][j] = distanceTable[i - 1][j - 1];
					} else {
						int a = distanceTable[i - 1][j];
						int b= distanceTable[i][j - 1];
						int c = distanceTable[i - 1][j - 1];
						int min = a < b ? (a < c ? a : (b < c ? b : c)) : b < c ? b : (c < a ? c : a);
						distanceTable[i][j] = 1 + min;
					}
				}
			}
		}
		return distanceTable[rows-1][columns-1];
	}

	public static void main(String[] args) {
		MinEditDistance m = new MinEditDistance();
		System.out.println(m.findEditDistance("intention", "execution"));
	}
}
