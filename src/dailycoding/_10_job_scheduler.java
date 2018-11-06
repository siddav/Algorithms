package dailycoding;

import java.util.function.Function;

/**
 * 
 * This problem was asked by Apple.
 * 
 * Implement a job scheduler which takes in a function f and an integer n, and
 * calls f after n milliseconds.
 * 
 * @author vsidda
 *
 */
public class _10_job_scheduler {

	public static void schedule(Runnable f, long millis) {
		System.out.println("waiting...");
      try {
		Thread.sleep(1000l);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      f.run();
	}

	public static void main(String[] args) {
		schedule(() -> {
			System.out.println("printing....");
		}, 1000l);
	}
}
