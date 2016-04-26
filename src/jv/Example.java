package jv;

import java.util.ArrayList;
import java.util.List;

public class Example {
	List<String> numbers = new ArrayList<String>();
	int account = 10;

	Example() {
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		numbers.add("4");
	}

	public void add() {
		account++;
	}

	public void remove() {
		account--;
	}

	public void print() {
		System.out.println(account);
	}

	public static void main(String[] args) throws Exception {
		Example e = new Example();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					e.add();
				}

			}

		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 5; i++) {
					e.remove();
				}
			}

		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		e.print();
	}
}

class Task implements Runnable {
	Example example;

	Task(Example e) {
		this.example = e;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
