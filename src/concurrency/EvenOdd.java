package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOdd {

	Lock lock = new ReentrantLock();
	Condition even = lock.newCondition();
	Condition odd = lock.newCondition();

	public void print() {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			if (i % 2 != 0) {
				odd.signalAll();
				try {
					even.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " - " + i);				
			} else {
				even.signalAll();
				try {
					odd.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " - " + i);				
			}
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenOdd ev = new EvenOdd();
		Runnable e = new EvenThread(ev);
		Runnable o = new OddThread(ev);
		Thread t1 = new Thread(e);
		Thread t2 = new Thread(o);
		t1.start();
		t2.start();
	}
}

class EvenThread implements Runnable {
	EvenOdd e;

	EvenThread(EvenOdd e) {
		this.e = e;
	}

	@Override
	public void run() {
		e.print();
	}
}

class OddThread implements Runnable {
	EvenOdd e;

	OddThread(EvenOdd e) {
		this.e = e;
	}

	@Override
	public void run() {
		e.print();
	}
}
