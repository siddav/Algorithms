package ideserve;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramSort implements Comparator<String> {
	public static void main(String[] args) {
		String[] str = { "abcd", "abc", "abce", "acd", "abdc" };
		Arrays.sort(str, new AnagramSort());
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i] + " ");
		}
	}

	public String sort(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}

	@Override
	public int compare(String o1, String o2) {
		return sort(o1).compareTo(sort(o2));
	}
}
