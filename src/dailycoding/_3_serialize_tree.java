package dailycoding;

//import org.junit.Assert;

/**
 * Given the root to a binary tree, implement serialize(root), which serializes
 * the tree into a string, and deserialize(s), which deserializes the string
 * back into the tree.
 * 
 * For example, given the following Node class
 * 
 * class Node: def __init__(self, val, left=None, right=None): self.val = val
 * self.left = left self.right = right The following test should pass:
 * 
 * node = Node('root', Node('left', Node('left.left')), Node('right')) assert
 * deserialize(serialize(node)).left.left.val == 'left.left'
 * 
 * @author vsidda
 *
 */
/**
 * There are many ways to serialize and deserialize a binary tree, so don't
 * worry if your solution differs from this one. We will be only going through
 * one possible solution.
 * 
 * We can approach this problem by first figuring out what we would like the
 * serialized tree to look like. Ideally, it would contain the minimum
 * information required to encode all the necessary information about the binary
 * tree. One possible encoding might be to borrow S-expressions from Lisp. The
 * tree Node(1, Node(2), Node(3)) would then look like '(1 (2 () ()) (3 ()
 * ()))', where the empty brackets denote nulls.
 * 
 * To minimize data over the hypothetical wire, we could go a step further and
 * prune out some unnecessary brackets. We could also replace the 2-character
 * '()' with '#'. We can then infer leaf nodes by their form 'val # #' and thus
 * get the structure of the tree that way. Then our tree would look like 1 2 # #
 * 3 # #.
 * 
 * @author vsidda
 *
 */
public class _3_serialize_tree {

	public static void main(String[] args) {

		SNode root = new SNode("1");
		SNode left = new SNode("2");
		SNode right = new SNode("3");
		root.left = left;
		root.right = right;

		System.out.println("=====inorder=========");
		printNode(root);
		System.out.println("\n");

		String str = serialize(root);
		System.out.println("serialized tree " + str);
		SNode node = deserialize("1 2 # # 3 # #".split(" "), new Count(0));
		System.out.println("==============");
		printNode(node);
		System.out.println("==============");
		System.out.println("node.left.value  " + node.left.value);
//		Assert.assertTrue(node.left.value .equalsIgnoreCase("2"));
	}

	private static void printNode(SNode node) {
		if (node == null) {
			return;
		}
		printNode(node.left);
		System.out.print(node.value + " ");
		printNode(node.right);
	}

	static class Count {
		int index;

		Count(int index) {
			this.index = index;
		}
	}

	private static SNode deserialize(String[] str, Count index) {
		if (index.index >= str.length) {
			return null;
		}
		String s = str[index.index];
		index.index = index.index + 1;
		if (s.equalsIgnoreCase("#")) {
			return null;
		}
		SNode root = new SNode(s);
		root.left = deserialize(str, index);
		root.right = deserialize(str, index);
		return root;
	}

	private static String serialize(SNode root) {
		if (root == null) {
			return "#";
		}
		String v = root.value;
		String l = serialize(root.left);
		String r = serialize(root.right);
		return v + " " + l + " " + r;
	}

}

class SNode {
	String value;
	SNode left;
	SNode right;

	SNode(String value) {
		this.value = value;
	}
}
