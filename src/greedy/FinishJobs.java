package greedy;

public class FinishJobs {
	public static void main(String[] args) {
		int k = 4;
		int T = 5;
		int[] job = { 10, 7, 8, 12, 6, 8 };
		FinishJobs f = new FinishJobs();
		f.findMinTime(job, k, T, job.length);
	}

	private void findMinTime(int[] job, int k, int t, int n) {
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			end = end + job[i];
		}
		int ans = end;
		int jobMax = findJobMax(job);
		while (start <= end) {
			int mid = (start + end) / 2;

			// If it is possible to finish jobs in mid time
			if (mid >= jobMax && isPossible(mid, k, job, n)) {
				ans = Math.min(ans, mid); // Update answer
				end = mid - 1;
			} else
				start = mid + 1;
		}
		System.out.println("minimum time " + (ans * t));
	}

	private boolean isPossible(int time, int k, int[] job, int n) {
		int cnt = 1;

		int curr_time = 0; // time assigned to current assignee

		for (int i = 0; i < n;) {
			// If time assigned to current assignee exceeds max,
			// increment count of assignees.
			if (curr_time + job[i] > time) {
				curr_time = 0;
				cnt++;
			} else { // Else add time of job to current time and move
						// to next job.
				curr_time += job[i];
				i++;
			}
		}

		// Returns true if count is smaller than k
		return (cnt <= k);
	}

	private int findJobMax(int[] job) {
		int max = job[0];
		for (int i = 1; i < job.length; i++) {
			if (max < job[i]) {
				max = job[i];
			}
		}
		return max;
	}
}
