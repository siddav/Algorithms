package jv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VerticalOrder {

	public void printOrder(TreeNode root) {
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		map = populateMap(root, 0, map);
		Iterator<Entry<Integer, List<Integer>>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, List<Integer>> entry = it.next();
			List<Integer> vertical = entry.getValue();
			printList(vertical);
		}
	}

	private void printList(List<Integer> list) {
		if (list != null) {
			for (Integer i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public void inOrderIterative() {
		
	}
	private Map<Integer, List<Integer>> populateMap(TreeNode node, int hd, Map<Integer, List<Integer>> map) {
		if( node == null) {
			return map;
		}
		if (map.get(hd) == null) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(node.data);
			map.put(hd, l);
		} else {
			List<Integer> l = map.get(hd);
			l.add(node.data);
			map.put(hd, l);
		}

		populateMap(node.left, hd - 1, map);
		populateMap(node.right, hd + 1, map);
		return map;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);

		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);

		root.left = two;
		two.left = four;
		two.right = five;

		root.right = three;
		three.left = six;
		six.right = eight;
		three.right = seven;
		seven.right = nine;
		VerticalOrder v = new VerticalOrder();
		v.printOrder(root);
	}
}

class TreeNode {
	int data;
	TreeNode right;
	TreeNode left;

	TreeNode(int data) {
		this.data = data;
	}
}