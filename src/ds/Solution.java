package ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	static List<String> solution(int[] input) {
		List<String> output = new ArrayList<String>();
		List<Integer> primes = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			if (isPrime(input[i])) {
				primes.add(input[i]);
			}
		}
		Collections.sort(primes);
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < primes.size(); i++) {
			q.offer(new Node(primes.get(i) + "", i+1));
		}
		int index = 0;
		while (!q.isEmpty()) {
			Node node = q.remove();
			String str = node.str;
			output.add(str);
			index = node.index;
			for (int i = index; i < primes.size(); i++) {
				q.offer(new Node(str + "," + primes.get(i), i+1));
			}
		}
		return output;
	}

	static class Node {
		String str;
		int index;		

		Node(String str, int index) {
			this.str = str;
			this.index = index;
		}
		
		@Override
		public String toString() {
			return "Node [str=" + str + ", index=" + index + "]";
		}
	}

	static boolean isPrime(int number) {
		if (number < 0) {
			number = -number;
		}
		if (number == 1 || number == 0) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// int[] input = new int[args.length];
		// int[] input = { 0, 1, 2, 3, 4, 9, 12 };
		int[] input = { -1, 3, 5, 7, 10, 20, 1902, 8233 };
		int i;
		for (i = 0; i < args.length; i++)
			input[i] = Integer.parseInt(args[i]);
		List<String> outputList = solution(input);
		printOutput(outputList);
	}

	public static void printOutput(List<String> output) {
		int size = output.size();
		for (int i = 0; i < size; i++)
			System.out.println(output.get(i));
	}
}
