package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast
 * 
 * @author vsidda
 *
 */
public class SherlockAndBeast {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(getMaxNumber(N));
		}
	}

	private static String getMaxNumber(int n) {
		int max3s = n / 5;
		String max = "-1";
		for (int i = 0; i <= max3s; i++) {
			int n3s = 5 * i;
			int n5s = n - n3s;
			if (n5s % 3 == 0) {
				 max = get5sAnd3s(n5s, n3s);
				 break;
			}
		}
		return max;
	}

	private static String get5sAnd3s(int n5s, int n3s) {
		String r = "";
		while (n5s > 0) {
			r = r + 5;
			n5s--;
		}
		while (n3s > 0) {
			r = r + 3;
			n3s--;
		}
		return r;
	}
}
