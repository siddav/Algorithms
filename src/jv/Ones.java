package jv;

public class Ones {
	public static void main(String[] args) {
		int[] a = { 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0 };
		int bestLength = 0;
		int bestPosition = -1;
		int previous = a[0];
		int count = 0;		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				count++;
			} else {
				if (bestLength < count) {
					bestLength = count;
					bestPosition = i - 1;					
				}
				count = 0;
			}
		}

		System.out.println("length: " + bestLength + " pos: " + (bestPosition - bestLength + 1));
	}
}
