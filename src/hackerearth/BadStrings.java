package hackerearth;

import java.util.Scanner;

public class BadStrings {
	void printGoodString(char[] str) {
		char[] res = new char[str.length];
		char prev = '\u0000';
		for (int i = 0, k = 0; i < str.length; i++) {
			if (str[i] != prev) {
				res[k++] = str[i];
			}
			prev = str[i];
		}
		System.out.println(String.valueOf(res));
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BadStrings b = new BadStrings();
		int N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			b.printGoodString(scan.next().toCharArray());
		}
	}
}
