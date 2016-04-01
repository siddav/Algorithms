package ramana;

public class HeightBtree {
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
	}
}
