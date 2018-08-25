package dailycoding;

import java.util.Comparator;
import java.util.PriorityQueue;

import util.utils;

public class MergeNLists {
	public static void main(String[] args) {
		int[][] a = { { 10, 15, 30 }, { 12, 15, 20 }, { 17, 20, 32 } };

		int[] merged = mergeKLists(a);
		utils.printArray(merged);
	}

	private static int[] mergeKLists(int[][] a) {
		int k = a.length;
		int n = a[0].length;
		int[] merged = new int[k * n];
		int m = 0;
		class Node {
			int r;
			int c;
			int v;

			Node(int r, int c, int v) {
				this.r = r;
				this.c = c;
				this.v = v;
			}

			@Override
			public String toString() {
				return "(" + r + "," + c + "," + v + ")";
			}
		}
		Node[][] nodes = new Node[k][n];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				nodes[i][j] = new Node(i, j, a[i][j]);
			}
		}
		PriorityQueue<Node> p = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.v - o2.v;
			}
		});
		for (int i = 0; i < k; i++) {
			p.add(nodes[i][0]);
		}
		while (!p.isEmpty()) {
			Node top = p.remove();
			merged[m++] = top.v;
			// if we still have elements in the corresponding row
			if (top.c < nodes[top.r].length - 1) {
				p.add(nodes[top.r][top.c + 1]);
			}
		}
		return merged;
	}
}
