package dailycoding;

/**
 * 
 * This problem was asked by Amazon.
 * 
 * There exists a staircase with N steps, and you can climb up either 1 or 2
 * steps at a time. Given N, write a function that returns the number of unique
 * ways you can climb the staircase. The order of the steps matters.
 * 
 * For example, if N is 4, then there are 5 unique ways:
 * 
 * 1, 1, 1, 1 2, 1, 1 1, 2, 1 1, 1, 2 2, 2 What if, instead of being able to
 * climb 1 or 2 steps at a time, you could climb any number from a set of
 * positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or
 * 5 steps at a time.
 * 
 * @author vinodreddy.sidda
 *
 */
public class _12_staircase {
	public static void main(String[] args) {
		int N = 4;
		System.out.println("Number of ways " + stairCase_1or2(N));

		int[] x = { 1, 2 };
		System.out.println("Number of ways via set " + stairCase_set(N, x));

		System.out.println("Number of ways via set DP " + stairCase_set_DP(N, x));
	}

	/**
	 * this is actually fibnocci series f(n) = f(n-1) + f(n-2) complexity: O(2
	 * power n)
	 * 
	 * @param N
	 * @return
	 */
	private static int stairCase_1or2(int N) {
		if (N <= 1) return 1;
			return stairCase_1or2(N - 1) + stairCase_1or2(N - 2);
	}

	/**
	 * similar to fibnocci we can apply complexity: O(|X| power n)
	 * 
	 * @param N
	 * @param x
	 * @return
	 */
	private static int stairCase_set(int N, int[] x) {
		if (N == 0) {
			return 1;
		}
		if (N < 0) {
			return 0;
		}
		int ways = 0;
		for (int step : x) {
			ways += stairCase_set(N - step, x);
		}
		return ways;
	}

	/**
	 * O( N * |X| ) time using DP
	 */
	private static int stairCase_set_DP(int N, int[] X) {
		int[] cache = new int[N + 1];
		cache[0] = 1;
		for (int i = 1; i < N + 1; i++) {
			for (int x : X) {
				if (i - x >= 0) {
					cache[i] += cache[i - x];
				}
			}
		}
		return cache[N];
	}
}
