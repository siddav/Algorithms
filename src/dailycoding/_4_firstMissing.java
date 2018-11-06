package dailycoding;

import java.util.ArrayList;
import java.util.List;

/**
 * This problem was asked by Stripe.
 * 
 * Given an array of integers, find the first missing positive integer in linear
 * time and constant space. In other words, find the lowest positive integer
 * that does not exist in the array. The array can contain duplicates and
 * negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 4,6]
 * should give 3.
 * 
 * @author vsidda
 *
 */
public class _4_firstMissing {
	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 6 };
		System.out.println("first missing " + findFirstMissing(a));
		//System.out.println("first given missing " + findFirstMissing_given(a));		
	}

	private static int findFirstMissing(int[] nums) {
		if (nums == null) {
			return 1;
		}
		List<Integer> a = new ArrayList<>();
		for (int n : nums) {
			if (n > 0)
				a.add(n);
		}

		for (int i = 0; i < a.size(); i++) {
			if (Math.abs(nums[i]) - 1 < a.size() && nums[Math.abs(nums[i]) - 1] > 0)
				a.set(Math.abs(nums[i]) - 1, -nums[Math.abs(nums[i]) - 1]);
		}
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > 0) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
/** Doubt logic
	private static int findFirstMissing_given(int[] nums) {
		if (null != nums) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			while (i + 1 != nums[i] && 0 < nums[i] && nums[i] <= nums.length) {
				int v = nums[i];
				nums[i] = nums[v - i];
				nums[v - 1] = nums[i];
				nums[v - 1] = v;
				if (nums[i] == nums[v - 1]) {
					break;
				}
			}
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != i) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
	**/
}
