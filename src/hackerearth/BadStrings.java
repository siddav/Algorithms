package hackerearth;

import java.util.Scanner;

public class BadStrings {
	void printGoodString(char[] str) {
		char[] res = new char[str.length + 1];
		char prev = str[0];
		int i = 1;
		int k = 0;
		res[k++] = prev;
		for (; i < str.length; i++) {
			if (str[i] != prev) {
				res[k++] = str[i];
			}
			prev = str[i];
		}
		System.out.println(res);
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
