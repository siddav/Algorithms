package ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Xor {
	static int solve(int x, int l, int r) {
		int max = -1;
		for (int i = l; i < r; i++) {
			int res = x ^ i;
			if (max < res) {
				max = res;
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(solve(4, 2, 8));
	}
}
