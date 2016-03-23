package jv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class A {
	static {
		GenricsTest t = new GenricsTest();
	}
}

public class GenricsTest {
	static {
		A a = new A();
	}

	public static void main(String[] args) {
		int i = 1;
		int j = 10;
		do {
			if (i > j) {
				break;
			}
			j--;
		} while (++i < 5);
		System.out.println(i);
		System.out.println(j);
	}
}
