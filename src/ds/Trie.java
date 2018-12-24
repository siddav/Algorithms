package ds;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	private static int ALPHABET_SIZE = 26;
	private Trie[] children = new Trie[ALPHABET_SIZE];
	char content;
	private boolean isEndOfWord;

	public void insert(String s) {
		Trie t = this;
		for (char ch : s.toCharArray()) {
			int index = index(ch);
			if (t.children[index] == null) {
				t.children[index] = new Trie();
			}
			t = t.children[index];
			t.content = ch;
		}
		t.isEndOfWord = true;
	}

	public List<String> elements(String prefix) {
		Trie t = this;
		for (char ch : prefix.toCharArray()) {
			int index = index(ch);
			t = t.children[index];
		}

		return elementsFrom(t, prefix.substring(0, prefix.length() - 1), new ArrayList<>());
	}

	public List<String> elementsFrom(Trie t, String prefix, List<String> result) {
		if (t == null) {
			return result;
		}
		if (t.isEndOfWord) {
			result.add(prefix + t.content);
		}
		for (Trie c : t.children) {
			if (c != null) {
				elementsFrom(c, prefix + t.content, result);
			}
		}
		return result;
	}

	public void print() {
		Trie t = this;
		for (Trie child : t.children) {
			print("", child);
		}
	}

	private void print(String prefix, Trie t) {
		if (t == null) {
			return;
		}
		if (t.isEndOfWord) {
			System.out.println(prefix + t.content);
		}
		for (Trie child : t.children) {
			if (child != null) {
				print(prefix + t.content, child);
			}
		}
	}

	public int index(char ch) {
		return ch - 'a';
	}

	public String toString() {
		return this.content + "";
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("dog");
		t.insert("deer");
		t.insert("deal");
		t.print();
		System.out.println("printing.........");
		t.elements("de").forEach(System.out::println);
	}
}
