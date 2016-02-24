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
		List listOfRawTypes = new ArrayList();
		listOfRawTypes.add("abc");
		//listOfRawTypes.add(123); //compiler will allow this - exception at runtime
		String item =  (String) listOfRawTypes.get(0); //explicit cast is required
		//item = (String) listOfRawTypes.get(1);
		System.out.println(item);
		Set<? extends Object> SetOfObject = new HashSet<String>(); 
	}
}
