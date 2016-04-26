package geeks;

public class ArrayUnions {

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 5, 7 };
		int[] b = { 2, 3, 5, 6 };
		printArrayUnion(a, b);
	}

	private static void printArrayUnion(int[] a, int[] b) {
		int i = 0;
		int j = 0;
		int alength = a.length;
		int blength = b.length;
		int prev = 0;

		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				System.out.println(a[i++]);
			} else if (a[i] > b[j]) {
				System.out.println(b[j++]);
			} else {
				int cur = a[i];
				System.out.println(a[i++]);
				j++;

				while (cur == a[i]) {
					i++;
				}
				while (cur == b[j]) {
					j++;
				}
			}
		}
		while (i < alength) {
			System.out.println(a[i++]);
		}
		while (j < blength) {
			System.out.println(b[j++]);
		}
	}
}
