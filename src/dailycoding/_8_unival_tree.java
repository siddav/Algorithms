package dailycoding;

public class _8_unival_tree {
	public static void main(String[] args) {
      UNode root = new UNode(0);
      UNode one = new UNode(1);
      UNode two = new UNode(0);
      
      UNode three = new UNode(1);
      UNode four = new UNode(0);
      
      UNode five = new UNode(1);
      UNode six = new UNode(1);
      
      root.left = one;
      root.right = two;
      
      two.left = three;
      two.right = four;
      
      three.left = five;
      three.right = six;
      
      System.out.println(" " + findUnivalSubtrees(root));
	}

	private static int findUnivalSubtrees(UNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		int left = 0;
		int right = 0;
		int rightData = -1;
		int leftData = -1;
		if(root.left != null) {
		   left = findUnivalSubtrees(root.left);
		    leftData = root.left.data;
		}
		if(root.right != null) {
			right = findUnivalSubtrees(root.right);
			rightData = root.right.data;
		}	
		boolean isUnival = false;
		if(rightData == -1) {
			isUnival = (root.data == leftData);
		}
		if(leftData == -1) {
			isUnival = (root.data == rightData);
		}
		if(rightData != -1 && leftData != -1) {
			isUnival = (root.data == rightData && root.data == leftData);
		}
		if(isUnival) {
			return left + right + 1;
		}
		return left + right;
	}
}

class UNode {
	int data;
	UNode left;
	UNode right;

	UNode(int data) {
		this.data = data;
	}
}