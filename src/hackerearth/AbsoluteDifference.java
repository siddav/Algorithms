package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AbsoluteDifference {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			String[] a = line.split(" ");
			int n = Integer.valueOf(a[0]);
			int d = Integer.valueOf(a[1]);
			line = br.readLine();
			String[] array = br.readLine().split(" ");
			for (int j = 0; j < array.length - 1; j++) {
				if (Math.abs(Integer.valueOf(a[j]) - Integer.valueOf(a[j + 1])) <= d) {
					System.out.println("YES");
					break;
				}
			}
			System.out.println("NO");
		}
	}
}
