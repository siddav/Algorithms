package util;

import java.util.ArrayList;
import java.util.List;

public class utils {
	public static <T extends Object> List<T> convertArrayToList(T[] arr) {
		List<T> es = new ArrayList<>();
		for (T t : arr) {
			es.add(t);
		}
		return es;
	}

	public static void printArray(int[] a) {
		System.out.println("\n---------");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
