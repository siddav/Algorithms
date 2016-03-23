package ideserve;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * http://www.ideserve.co.in/learn/set-partition-problem-dynamic-programming
 * 
 * @author sidda
 *
 */
public class SetPartitionProblem {
	public static void main(String[] args) {
		int[] set = { 15, 5, 15, 20, 45 };		
		SetPartitionProblem p = new SetPartitionProblem();
		System.out.println(p.isPartitionExists(set));
	}

	private boolean isPartitionExists(int[] set) {

		int sum = 0;
		for (int i = 0; i < set.length; i++) {
			sum = sum + set[i];
		}
		if (sum % 2 != 0) {
			return false;
		}				
		Queue<String> s = new PriorityQueue<String>();
		return partitionPossible(sum / 2, 0, set);
	}

	private boolean partitionPossible(int requiredSum, int index, int[] set) {
		if (requiredSum == 0) {
			return true;
		}
		if (index == set.length) {
			return false;
		}
		return partitionPossible(requiredSum - set[index], index + 1, set)
				|| partitionPossible(requiredSum, index + 1, set);
	}
}
