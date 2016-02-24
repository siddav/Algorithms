package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class VideoConference implements Runnable {

	private CountDownLatch latch;

	VideoConference(int number) {
		latch = new CountDownLatch(number);
	}

	public void arrive(String name) {
		System.out.printf("%s has arrrived\n", name);
		latch.countDown();
	}

	@Override
	public void run() {
		System.out.printf("VideoConference: Initialization: %d participants.\n", latch.getCount());
		try {
			latch.await();
			System.out.printf("VideoConference: All the participants have come\n");
			System.out.printf("VideoConference: Let's start...\n");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		VideoConference v = new VideoConference(5);
		Thread conf = new Thread(v);
		conf.start();
		Thread[] participants = new Thread[10];
		for (int i = 0; i < participants.length; i++) {
			Participant p = new Participant(v, "participant " + i);
			Thread t = new Thread(p);
			t.start();
		}
			
	}
}

class Participant implements Runnable {
	String name;
	VideoConference conference;

	Participant(VideoConference conference, String name) {
		this.name = name;
		this.conference = conference;
	}

	@Override
	public void run() {
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		conference.arrive(name);
	}
}