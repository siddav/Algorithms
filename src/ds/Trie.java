package ds;

public class Trie {
	TrieNode root;

	public void insert(String str) {
		if (str == null || str == "") {
			return;
		}
		insertHelper(str, 0, 0, root);
	}

	public void insertHelper(String str, int pos, int level, TrieNode node) {
       if(node == null) {
    	   
       }
	}

	public static void main(String[] args) {

	}
}

class TrieNode {
	private static int ALPHABET_SIZE = 26;
	private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
	private boolean isEndOfWord;
}