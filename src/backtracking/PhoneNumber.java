package backtracking;

public class PhoneNumber {
	static String[] hashTable = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	static void printWordsUtil(int number[], int curr_digit, char output[], int n) {
		// Base case, if current output word is prepared
		int i;
		if (curr_digit == n) {
			System.out.println(String.valueOf(output));
			return;
		}

		// Try all 3 possible characters for current digir in number[]
		// and recur for remaining digits
		for (i = 0; i < (hashTable[number[curr_digit]]).length(); i++) {
			output[curr_digit] = hashTable[number[curr_digit]].charAt(i);
			printWordsUtil(number, curr_digit + 1, output, n);
			if (number[curr_digit] == 0 || number[curr_digit] == 1)
				return;
		}
	}

	static void printWords(int number[], int n) {
		char[] result = new char[n + 1];
		printWordsUtil(number, 0, result, n);
	}

	public static void main(String[] args) {
		int number[] = { 2, 3, 1 };
		printWords(number, number.length);
	}
}
