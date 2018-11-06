package ds;

import java.util.ArrayList;
import java.util.List;

public class TernarySearchTree {
	private TNode root;

	public void add(String s) {
		if (s == "" || s == null) {
			return;
		}
		root = addHelper(s, 0, root);
	}

	private TNode addHelper(String s, int pos, TNode node) {
		if (pos >= s.length()) {
			return node;
		}
		if (node == null) {
			node = new TNode(s.charAt(pos), false);
		}

		if (s.charAt(pos) < node.ch) {
			node.left = addHelper(s, pos, node.left);
		} else if (s.charAt(pos) > node.ch) {
			node.right = addHelper(s, pos, node.right);
		} else {
			if (pos + 1 == s.length()) {
				node.endOfWord = true;
			} else {
				node.centre = addHelper(s, pos + 1, node.centre);
			}
		}
		return node;
	}

	public boolean contains(String s) {
		if (s == null || s == "") {
			return false;
		}
		return containsHelper(s, 0, root);
	}

	private boolean containsHelper(String s, int pos, TNode root) {
		if (root == null) {
			return false;
		}
		if (pos >= s.length()) {
			return false;
		}
		if (root.endOfWord) {
			return true;
		} else if (s.charAt(pos) == root.ch) {
			return containsHelper(s, pos + 1, root.centre);
		} else if (s.charAt(pos + 1) > root.ch) {
			return containsHelper(s, pos + 1, root.right);
		} else {
			return containsHelper(s, pos + 1, root.left);
		}
	}

	private List<String> findAllWords() {
		if (root == null) {
			return null;
		}
		return findAllWords(root, "", new ArrayList<String>());
	}

	private List<String> findAllWords(TNode node, String s, List<String> finalList) {
		if (node != null) {
			if (node.endOfWord) {

				finalList.add(s + node.ch);
			}
			findAllWords(node.left, s, finalList);
			findAllWords(node.right, s, finalList);
			findAllWords(node.centre, s + node.ch, finalList);
		}
		return finalList;
	}

	public static void main(String[] args) {
		TernarySearchTree tree = new TernarySearchTree();
		tree.add("ABCD");
		tree.add("BCD");
		tree.add("ABCBA");

		System.out.println("contains " + tree.contains("ABCD"));
		System.out.println("contains " + tree.contains("ABCBA"));
		System.out.println("contains " + tree.contains("ACBA"));

		tree.findAllWords().forEach(it -> {
			System.out.println(it);
		});
	}
}

class TNode {
	char ch;
	TNode left, right, centre;
	boolean endOfWord;

	TNode(char ch, boolean endOfWord) {
		this.ch = ch;
		this.endOfWord = endOfWord;
	}
}