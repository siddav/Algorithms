package jv;

import java.util.ArrayList;
import java.util.List;

public class Myclass {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(null);
		l.add(null);
		for (Integer i : l) {
			System.out.println("here");
		}
		System.out.println(l.size());
	}
}
