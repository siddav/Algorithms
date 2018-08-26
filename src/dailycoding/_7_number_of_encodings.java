package dailycoding;

/**
 * This problem was asked by Facebook.
 * 
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the
 * number of ways it can be decoded.
 * 
 * For example, the message '111' would give 3, since it could be decoded as
 * 'aaa', 'ka', and 'ak'.
 * 
 * You can assume that the messages are decodable. For example, '001' is not
 * allowed.
 * 
 * @author vsidda
 *
 */
public class _7_number_of_encodings {
	public static void main(String[] args) {
		String a = "111";
		System.out.println("" + findEncodings(a));
		System.out.println("DP " + findEncodings_DP(a.toCharArray(), a.length()));
		System.out.println("Dojo " + findEncodings_dojo(a));
		System.out.println("Dojo DP " + findEncodings_dojo_DP(a));
		
		String b = "26";
		System.out.println("" + findEncodings(b));
		System.out.println("DP " + findEncodings_DP(b.toCharArray(), b.length()));

		String c = "20";
		System.out.println("" + findEncodings(c));
		System.out.println("DP " + findEncodings_DP(c.toCharArray(), c.length()));

		String d = "";
		System.out.println("" + findEncodings(d));
		System.out.println("DP " + findEncodings_DP(d.toCharArray(), d.length()));

	}

	private static int findEncodings(String a) {
		if (a == null) {
			return 0;
		}
		if (a.length() <= 1) {
			return 1;
		}
		if (a.startsWith("0")) {
			return 0;
		}
		int total = 0;
		if (Integer.parseInt(a.substring(0, 2)) <= 26) {
			total += findEncodings(a.substring(2));
		}
		total += findEncodings(a.substring(1));
		return total;
	}

	private static int findEncodings_DP(char[] digits, int n) {
		if (n == 0) {
			return 1;
		}
		int[] count = new int[n + 1]; // A table to store results of subproblems
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			count[i] = 0;

			// If the last digit is not 0, then last digit must add to
			// the number of words
			if (digits[i - 1] > '0')
				count[i] = count[i - 1];

			// If second last digit is smaller than 2 and last digit is
			// smaller than 7, then last two digits form a valid character
			if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
				count[i] += count[i - 2];
		}
		return count[n];
	}

	private static int findEncodings_dojo(String a) {
		return findEncodings_dojo_helper(a.toCharArray(), a.length());
	}

	/**
	 * k refers we have to see last k characters, in this way we avoid creating
	 * new strings
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	private static int findEncodings_dojo_helper(char[] a, int k) {
		if (k == 0) {
			return 1;
		}
		int s = a.length - k;
		if (a[s] == '0') {
			return 0;
		}
		int result = findEncodings_dojo_helper(a, k - 1);
		if (k >= 2 && Integer.parseInt(a[s] + "" + a[s + 1]) <= 26) {
			result = result + findEncodings_dojo_helper(a, k - 2);
		}
		return result;
	}
	
	private static int findEncodings_dojo_DP(String a) {
		Integer[] memo = new Integer[a.length() + 1];
		return findEncodings_dojo_helper_DP(a.toCharArray(), a.length(), memo);
	}

	/**
	 * k refers we have to see last k characters, in this way we avoid creating
	 * new strings
	 *  O(N)
	 * @param a
	 * @param k
	 * @return
	 */
	private static int findEncodings_dojo_helper_DP(char[] a, int k, Integer[] memo) {
		if (k == 0) {
			return 1;
		}
		int s = a.length - k;
		if (a[s] == '0') {
			return 0;
		}
		//dp step
		if(memo[k] != null) {
			return memo[k];
		}
		int result = findEncodings_dojo_helper(a, k - 1);
		if (k >= 2 && Integer.parseInt(a[s] + "" + a[s + 1]) <= 26) {
			result = result + findEncodings_dojo_helper(a, k - 2);
		}
		//dp step
		memo[k] = result;
		return result;
	}
}
