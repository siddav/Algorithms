package ramana;

import java.util.Stack;

public class PostOrderTraveralWithOutRecursion {

	public static void main(String[] args) {
		/*
		 *     3 
		 *   2   1
		 *  4 5 6 7
		 * 
		 * preorder traversal of above tree is 3 2 4 5 1 6 7 postorder traversal
		 * of above tree is 4 5 2 6 7 1 3
		 */
		TNode root = new TNode(3);
		TNode two = new TNode(2);
		TNode one = new TNode(1);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode seven = new TNode(7);

		root.left = two;
		root.right = one;
		two.left = four;
		two.right = five;
		one.left = six;
		one.right = seven;
		
		System.out.println("\n----post order traversal----");
		preOrder(root);
		System.out.println("\n----post order traversal----");
		postOrder(root);
		System.out.println("\nheight of binary tree " + height(root));
	}

	private static int height(TNode root) {
		if(root == null) {
			return 0;
		}		
		int lHeight = height(root.left);
		int rHeight = height(root.right);		
		return 1 + (lHeight > rHeight ? lHeight : rHeight);
	}

	private static void postOrder(TNode node) {
		if (node == null) {
			return;
		}
		Stack<TNode> st1 = new Stack<TNode>();
		Stack<TNode> st2 = new Stack<TNode>();
		st1.push(node);
		while (!st1.isEmpty()) {
			TNode n = st1.pop();
			st2.push(n);
			if (n.left != null)
				st1.push(n.left);
			if (n.right != null)
				st1.push(n.right);
		}
		// After this the postOrder will be in stack2, all that we have to do is
		// pop the elements
		while (!st2.isEmpty()) {
			TNode n = st2.pop();
			System.out.print(n.data + " ");
		}
	}

	// preOrder with put recursion
	private static void preOrder(TNode node) {
		if (node == null) {
			return;
		}
		Stack<TNode> st = new Stack<TNode>();
		while (node != null) {
			System.out.print(node.data + " ");
			st.push(node);
			node = node.left;
		}
		while (!st.isEmpty()) {
			TNode n = st.pop();
			if (n.right != null) {
				node = n.right;
				while (node != null) {
					System.out.print(node.data + " ");
					st.push(node);
					node = node.left;
				}
			}
		}
	}
}

class TNode {
	int data;
	TNode left;
	TNode right;

	TNode(int data) {
		this.data = data;
	}
}