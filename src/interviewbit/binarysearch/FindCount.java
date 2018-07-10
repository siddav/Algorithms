package interviewbit.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import util.utils;

/**
 * Given a sorted array of integers, find the number of occurrences of a given
 * target value. Your algorithm’s runtime complexity must be in the order of
 * O(log n). If the target is not found in the array, return 0
 ** 
 * Example : ** Given [5, 7, 7, 8, 8, 10] and target value 8, return 2.
 * 
 * @author sidda
 *
 */
public class FindCount {
	int binarySearch(final List<Integer> A, int B) {
		if (A == null) {
			return -1;
		}
		if (A.size() == 0) {
			return -1;
		}
		int low = 0;
		int high = A.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A.get(mid) == B) {
				return mid;
			} else {
				if (A.get(mid) > B) {
					high = mid - 1;
				}
				if (A.get(mid) < B) {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public int findCount(final List<Integer> A, int B) {
		int index = binarySearch(A, B);
		if (index == -1) {
			return 0;
		} else {
			// left count
			int l = 0;
			int r = 0;
			int lIndex = index - 1;
			int rIndex = index + 1;
			while (lIndex >= 0 && A.get(lIndex) == B) {
				l++;
				lIndex--;
			}
			// right count
			while (rIndex < A.size() && A.get(rIndex) == B) {
				r++;
				rIndex++;
			}
			return l + r + 1;
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 5, 7, 9, 10, 12 };
		List<Integer> arr = utils.convertArrayToList(a);
		FindCount fCount = new FindCount();
		System.out.println("9 found " + fCount.binarySearch(arr, 9));
		System.out.println("11 found " + fCount.binarySearch(arr, 11));

		Integer[] b = { 5, 7, 7, 8, 8, 10 };
		List<Integer> arrB = utils.convertArrayToList(b);
		System.out.println("8 number of times " + fCount.findCount(arrB, 8));
	}
}