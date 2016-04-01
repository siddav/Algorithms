package jv;

import java.util.HashSet;
import java.util.Iterator;
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
		 Set<Integer> hashset= new HashSet<Integer>();

	        hashset.add(null);
	        hashset.add(22);
	        hashset.add(222);
	        hashset.add(null);
	        hashset.add(11);
	        hashset.add(233);
	        //  TreeSet<String> tset=hashset;

	      Iterator<Integer> it = hashset.iterator();
	        while(it.hasNext()){
	            Integer i = it.next();
	            System.out.print(i+" ");
	        }
	}
}
