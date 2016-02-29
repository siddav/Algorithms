package hackerearth;

import java.util.Stack;

public class LinkedListaddition {

	public static void main(String[] args) {
		LNode l1 = new LNode(5);
		LNode s = new LNode(6);
		LNode se = new LNode(7);
		LNode n = new LNode(9);
		l1.next = s;
		s.next = se;
		se.next = n;

		LNode l2 = new LNode(2);
		LNode o = new LNode(1);
		LNode oe = new LNode(1);
		l2.next = o;
		o.next = oe;
		LinkedListaddition a = new LinkedListaddition();
		System.out.println("\n---- l1 ----- ");
		a.print(l1);
		System.out.println("\n---- l2 ----- ");
		a.print(l2);
		LNode l = a.add(l1, l2);				
		System.out.println("\n---- result ----- ");
		a.print(l);
	}

	private void print(LNode l) {
		LNode current = l;
		System.out.println("");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	private LNode add(LNode l1, LNode l2) {

		Stack<LNode> s1 = new Stack<LNode>();
		Stack<LNode> s2 = new Stack<LNode>();
		LNode current = l1;
		while (current != null) {
			s1.push(current);
			current = current.next;
		}
		current = l2;
		while (current != null) {
			s2.push(current);
			current = current.next;
		}
		LNode result = null;
		int carry = 0;
		while (!s1.isEmpty() && !s2.isEmpty()) {
			LNode n1 = s1.pop();
			LNode n2 = s2.pop();
			int sum = n1.data + n2.data + carry;
			carry = sum / 10;
			if (result == null) {
				result = new LNode(sum % 10);
			} else {
				LNode n = new LNode(sum % 10);
				n.next = result;
				result = n;
			}
		}

		while (!s1.isEmpty()) {
			LNode l = s1.pop();
			int sum = carry + l.data;
			carry = sum / 10;
			l.data = (sum % 10);
			l.next = result;
			result = l;
		}
		while (!s2.isEmpty()) {
			LNode l = s1.pop();
			int sum = carry + l.data;
			carry = sum / 10;
			l.data = (sum % 10);
			l.next = result;
			result = l;
		}
		return result;
	}

}

class LNode {
	int data;
	LNode next;

	LNode(int data) {
		this.data = data;
	}
}