package me.y2o2u2n.p581;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by JunSeok Youn on 2021-04-15
 */
public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15})); // 5
		System.out.println(findUnsortedSubarray(new int[] {1, 2, 3, 4})); // 0
		System.out.println(findUnsortedSubarray(new int[] {1})); // 0
		System.out.println(findUnsortedSubarray(new int[] {1, 3, 2, 2, 2})); // 4
		System.out.println(findUnsortedSubarray(new int[] {1, 2, 3, 2, 2, 2})); // 4
		System.out.println(findUnsortedSubarray(new int[] {2, 3, 3, 2, 4})); // 3
		System.out.println(findUnsortedSubarray(new int[] {1, 2, 4, 5, 3})); // 3
		System.out.println(findUnsortedSubarray(new int[] {2, 1})); // 2
		System.out.println(findUnsortedSubarray(new int[] {2, 1, 1})); // 3
		System.out.println(findUnsortedSubarray(new int[] {2, 1, 3})); // 2
		System.out.println(findUnsortedSubarray(new int[] {2, 1, 3, 2, 3})); // 4
		System.out.println(findUnsortedSubarray(new int[] {1, 2, 5, 3, 4})); // 3
		System.out.println(findUnsortedSubarray(new int[] {2, 3, 1, 4, 5})); // 3
	}

	private static int findUnsortedSubarray(int[] nums) {
		int length = nums.length;

		boolean isSorted = true;
		int temp = nums[0];
		for (int i = 1; i < length; i++) {
			if (temp > nums[i]) {
				// unsorted
				isSorted = false;
			} else {
				// sorted
			}

			temp = nums[i];
		}

		if (isSorted) {
			return 0;
		}

		int num = nums[0];
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 1; i < length; i++) {
			if (num > nums[i]) {
				// unsorted
				deque.add(i);
			} else {
				// sorted
			}

			num = nums[i];
		}

		Integer first = deque.peekFirst();
		Integer last = deque.peekLast();

		int f = first - 1;
		int l = last;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = f; i <= l; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}

		int ff = f;
		int ll = l;

		while (ff - 1 >= 0 && nums[ff - 1] > min) {
			ff--;
		}

		while (ll + 1 < length && nums[ll + 1] < max) {
			ll++;
		}

		return ll - ff + 1;
	}
}
