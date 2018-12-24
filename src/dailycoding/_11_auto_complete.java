package dailycoding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ds.Trie;

/**
 * This problem was asked by Twitter.
 * 
 * Implement an autocomplete system. That is, given a query string s and a set
 * of all possible query strings, return all strings in the set that have s as a
 * prefix.
 * 
 * For example, given the query string de and the set of strings [dog, deer,
 * deal], return [deer, deal].
 * 
 * Hint: Try preprocessing the dictionary into a more efficient data structure
 * to speed up queries.
 * 
 * @author vsidda
 *
 */
public class _11_auto_complete {
	public static void main(String[] args) {
		List<String> str = Arrays.asList("dog", "deer", "deal");
		String prefix = "de";
		System.out.println("naive way");
		autoComplete(prefix, str).forEach(System.out::println);
		System.out.println("efficient way");
		autoComplete_efficient_trie(prefix, str).forEach(System.out::println);
	}
/**
 * O(n) implementation
 * @param prefix
 * @param l
 * @return
 */
	private static List<String> autoComplete(final String prefix, List<String> l) {
		return l.stream().filter((s) -> s.startsWith(prefix)).collect(Collectors.toList());
	}
	/**
	 * still worst case can be o(n) if all the input strings has same prefix
	 */
	private static List<String> autoComplete_efficient_trie(final String prefix, List<String> l) {
		Trie t = new Trie();
		l.forEach(s -> t.insert(s));
		return t.elements(prefix);
	}
}
