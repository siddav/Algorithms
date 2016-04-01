package hackerearth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InorderIterative {
	int j = 10;

	public void inOrder(Node root) {
		InorderIterative iq = new InorderIterative();
		if (root == null) {
			return;
		}
		Node current = root;
		Stack<Node> stk = new Stack<Node>();
		while (current != null || !stk.isEmpty()) {
			if (current != null) {
				stk.push(current);
				current = current.left;
			} else {
				current = stk.pop();
				System.out.println(current.data);
				current = current.right;
			}
		}
	}

	public void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		Node current = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(current);
		while (!q.isEmpty()) {
			current = q.remove();
			System.out.println(current.data);
			if (current.left != null) {
				q.add(current.left);
			}
			if (current.right != null) {
				q.add(current.right);
			}
		}
	}

	public void preOder(Node root) {

		if (root == null) {
			return;
		}
		Node current = root;
		Stack<Node> stk = new Stack<Node>();
		while (current != null || !stk.isEmpty()) {
			if (current != null) {
				System.out.println(current.data);
				stk.push(current);
				current = current.left;
			} else {
				current = stk.pop();
				current = current.right;
			}
		}

	}

	public void postOrder(Node root) {

		if (root == null) {
			return;
		}
		Node current = root;
		Stack<Node> stk = new Stack<Node>();
		while (current != null || !stk.isEmpty()) {
			if (current != null) {
				stk.push(current);
				current = current.left;
			} else {
				current = stk.pop();
				current = current.right;
				if (current != null)
					System.out.println(current.data);
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		InorderIterative i = new InorderIterative();
		System.out.println("-------inOrder-----------");
		i.inOrder(root);
		System.out.println("-------levelOrder-----------");
		i.levelOrder(root);
		System.out.println("-------preOrder-----------");
		i.preOder(root);
		System.out.println("-------postOrder-----------");
		i.postOrder(root);
	}
}

class Node {
	Node left;
	int data;
	Node right;

	Node() {

	}

	Node(int data) {
		this.data = data;
	}
}
