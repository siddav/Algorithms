package jv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Myclass {

	public static void main(String args[]) throws Exception { // Disable this to
																// avoid
																// ConcurrentModificationException
		List<String> companies = new ArrayList<>();

		// Enable this to avoid ConcurrentModificationException
		// List<String> companies = new CopyOnWriteArrayList<>();

		companies.add("Google");
		companies.add("Yahoo");
		companies.add("Facebook");
		companies.add("eBay");
		companies.add("Microsoft");
		
		companies.remove("Microsoft");

		// Get an iterator over a collection. Iterator takes the place of
		// Enumeration in the Java Collections Framework.
		Iterator<String> crunchifyIterator = companies.iterator();
		
		companies.remove("Microsoft");

		// Make changes to companies List while performing hasNext()
		while (crunchifyIterator.hasNext()) {

			System.out.println("companies list: " + companies);

			String crunchifyString = crunchifyIterator.next();

			// Test1: Below statement causes ConcurrentModificationException
			System.out.println(crunchifyString);
			if (crunchifyString.equals("Yahoo"))
				// modCount = 6
				crunchifyIterator.remove();
			/*if (crunchifyString.equals("eBay"))
				companies.add("My Message Goes here... eBay present");*/

			// Test2: Below change wont throw ConcurrentModificationException
			// Reason: It doesn't change modCount variable of "companies"
			/*if (crunchifyString.equals("Google"))
				companies.set(2, "Google");*/

		}
	}
}
