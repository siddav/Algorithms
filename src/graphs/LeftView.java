package graphs;

public class LeftView {
	

	public void printLeftView(Node n, IntWrapper maxLevel, int currentLevel) {
		if (n == null) {
			return;
		}
		if (maxLevel.value < currentLevel) {
			maxLevel.value = currentLevel;
			System.out.println(n.data);
		}

		printLeftView(n.left, maxLevel, currentLevel + 1);
		printLeftView(n.right, maxLevel, currentLevel + 1);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node two = new Node(2);
		//Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		root.left = two;
		root.right = four;
		//two.left = three;
		four.left = five;
		four.right = six;
		LeftView l = new LeftView();
		l.printLeftView(root, new IntWrapper(0), 1);
	}
}
class IntWrapper {
	int value;

	IntWrapper(int value) {
      this.value = value;
	}
}
class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}
}