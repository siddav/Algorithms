package hackerearth;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreOrder {

	public BTNode constructBinaryTree(List<Integer> a, int length) {
		if (a == null || length == 0) {
			return null;
		}
		BTNode n = new BTNode(a.get(0));
		if (length == 1) {
			return n;
		}
		int i = 1;
		while (a.get(0) >= a.get(i)) {
			i++;
		}
		n.left = constructBinaryTree(a.subList(1, i), a.subList(1, i).size());
		n.right = constructBinaryTree(a.subList(i, length), a.subList(i, length).size());
		return n;
	}

	public void inOrder(BTNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}

	}

	public void inOrderIterative(BTNode node) {
		if (node == null) {
			return;
		}
		Stack<BTNode> s = new Stack<BTNode>();
		BTNode current = node;
		while (current != null) {
			s.push(current);
			current = current.left;
		}
		while (!s.isEmpty()) {
			BTNode n = s.pop();
			System.out.println(n.data);
			if (n.right != null) {
				current = n.right;
				while (current != null) {
					s.push(current);
					current = current.left;
				}
			}

		}
	}

	public void preOrderIterative(BTNode node) {
		if (node == null) {
			return;
		}
		Stack<BTNode> s = new Stack<BTNode>();
		BTNode current = node;
		while (current != null) {
			System.out.println(current.data);
			s.push(current);
			current = current.left;
		}
		while (!s.isEmpty()) {
			BTNode n = s.pop();
			if (n.right != null) {
				current = n.right;
				while (current != null) {
					s.push(current);
					System.out.println(current.data);
					current = current.left;
				}
			}

		}
	}

	public void postOrderTraversal(BTNode node) {
		if (node == null) {
			return;
		}
		Stack<BTNode> s = new Stack<BTNode>();
		BTNode current = node;
		s.push(current);
		BTNode prev = null;
		while (!s.isEmpty()) {
			current = s.peek();
			// coming down - push element
			if (prev == null || prev.left == current || prev.right == current) {
				if (current.left != null) {
					s.push(current.left);
				} else if (current.right != null) {
					s.push(current.right);
				} else {
					System.out.println(current.data);
					s.pop();
				}
			}
			// coming up from left - peek root and check right
			if (prev == current.left) {
				if (current.right != null) {
					s.push(current.right);
				} else {
					System.out.println(current.data);
					s.pop();
				}
			}
			// coming up from right - print root
			if (prev == current.right) {
				System.out.println(current.data);
				s.pop();
			}
			prev = current;
		}
	}

	public static void main(String[] args) {
		PreOrder p = new PreOrder();
		Integer[] a = { 10, 5, 1, 7, 40, 50 };
		List<Integer> aList = Arrays.asList(a);
		BTNode n = p.constructBinaryTree(aList, aList.size());
		p.inOrder(n);
		System.out.println("inorder iterative ------");
		p.inOrderIterative(n);
		System.out.println("preorder iterative ------");
		p.preOrderIterative(n);
		System.out.println("postorder iterative ------");
		p.postOrderTraversal(n);
	}
}

class BTNode {
	BTNode left;
	BTNode right;
	int data;

	BTNode(int data) {
		this.data = data;
	}
}