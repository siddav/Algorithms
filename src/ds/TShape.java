package ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class TShape {
	static String solve(List<List<Integer>> grid) {

		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();
		for (List<Integer> l : grid) {
			int x = l.get(0);
			int y = l.get(1);
			if (xMap.get(x) != null) {
				xMap.put(x, xMap.get(x) + 1);
			} else {
				xMap.put(x, 1);
			}

			if (yMap.get(y) != null) {
				yMap.put(y, yMap.get(y) + 1);
			} else {
				yMap.put(y, 1);
			}
		}
		boolean foundX = false;
		boolean foundY = false;
		Integer x = null;
		Integer y = null;
		for (Map.Entry<Integer, Integer> entry : xMap.entrySet()) {
			if (entry.getValue() == 3) {
				x = entry.getKey();
			}
		}

		for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
			if (entry.getValue() == 3) {
				y = entry.getKey();
			}
		}

		if (x != null) {
			foundX = xMap.containsKey(x + 1) && xMap.containsKey(x) && xMap.containsKey(x - 1);
		}
		if (y != null) {
			foundY = yMap.containsKey(y + 1) && yMap.containsKey(y) && yMap.containsKey(y - 1);
		}

		return (foundX || foundY) ? "Yes" : "No";

	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		List<Integer> two = new ArrayList<>();
		List<Integer> three = new ArrayList<>();
		List<Integer> four = new ArrayList<>();
		List<Integer> five = new ArrayList<>();

		one.add(7);
		one.add(5);

		two.add(8);
		two.add(5);

		three.add(6);
		three.add(5);

		four.add(7);
		four.add(6);

		five.add(7);
		five.add(7);

		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		list.add(five);

		System.out.println(solve(list));
	}
}
