package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	LinkedList<Integer>[] adjacencyLists;
	int size;

	Graph(int size) {
		this.size = size;
		adjacencyLists = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			adjacencyLists[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		adjacencyLists[src].add(dest);
		// adjacencyLists[dest].add(src);
	}

	public boolean hasEdge(int src, int dest) {
		return adjacencyLists[src].contains(dest);
	}

	public void printGraph(Graph G) {
		int size = G.size;
		LinkedList<Integer>[] lists = G.adjacencyLists;
		for (int i = 0; i < size; i++) {
			System.out.print(i + "-");
			LinkedList<Integer> list = lists[i];
			for (Integer j : list) {
				System.out.print("->" + j);
			}
			System.out.println();
		}
	}

	public void BFS(int vertex) {
		boolean[] visited = new boolean[size];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[vertex] = true;
		q.add(vertex);
		System.out.print(vertex + " ");
		while (!q.isEmpty()) {
			int v = q.poll();
			LinkedList<Integer> adjacentVertices = adjacencyLists[v];
			for (Integer v1 : adjacentVertices) {
				if (!visited[v1]) {
					visited[v1] = true;
					System.out.print(v1 + " ");
					q.add(v1);
				}
			}
		}
	}

	public void DFS(int vertex) {
		Stack<Integer> stk = new Stack<Integer>();
		boolean[] visited = new boolean[this.size];
		visited[vertex] = true;
		System.out.print(vertex + " ");
		stk.push(vertex);
		while (!stk.isEmpty()) {
			int cur = stk.pop();
			LinkedList<Integer> list = adjacencyLists[cur];
			for (Integer i : list) {
				if (!visited[i]) {
					visited[i] = true;
					System.out.print(i + " ");
					stk.push(i);
				}
			}
		}
	}

	public boolean hasCycle(int vertex) {
		Stack<Integer> stk = new Stack<Integer>();
		boolean[] visited = new boolean[this.size];
		visited[vertex] = true;
		stk.push(vertex);
		while (!stk.isEmpty()) {
			int cur = stk.pop();
			LinkedList<Integer> list = adjacencyLists[cur];
			for (Integer i : list) {
				if (!visited[i]) {
					visited[i] = true;
					stk.push(i);
				} else if (visited[i]) {
					return true;
				}
			}
		}
		return false;
	}

	// A function used by DFS
	void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adjacencyLists[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS() {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[this.size];

		// Call the recursive helper function to print DFS traversal
		// starting from all vertices one by one
		for (int i = 0; i < this.size; ++i)
			if (visited[i] == false)
				DFSUtil(i, visited);
	}

	public boolean pathIandJ(int I, int J, Stack<Integer> path, boolean[] visited) {
		visited[I] = true;
		path.push(I);
		if (I == J) {
			return true;
		}
		LinkedList<Integer> list = adjacencyLists[I];
		for (Integer i : list) {
			if (!visited[i]) {
				visited[i] = true;
				if (pathIandJ(i, J, path, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);

        g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.printGraph(g);

		/*
		 * g.addEdge(0, 1); g.addEdge(0, 4); g.addEdge(1, 2); g.addEdge(1, 3);
		 * g.addEdge(1, 4); g.addEdge(2, 3); g.addEdge(3, 4);
		 */
		System.out.println("-- BFS --");
		g.BFS(2);
		System.out.println("\n-- DFS --");
		g.DFS(2);
		System.out.println("\n--complete DFS --");
		g.DFS();
		System.out.println("\n-- hasCycle --");
		System.out.println(g.hasCycle(2));
		System.out.println("\n-- hasPath --");
		Stack<Integer> st = new Stack<Integer>();
		boolean[] visited = new boolean[g.size];
		System.out.println(g.pathIandJ(2, 1, st, visited));
		System.out.println("");
		if (g.pathIandJ(2, 1, st, visited)) {
			for (Integer i : st) {
				System.out.print(i + " ");
			}
		}
	}
}
