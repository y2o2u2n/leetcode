package me.y2o2u2n.p215;

import java.util.Arrays;

/**
 * Created by JunSeok Youn on 2021-04-02
 */
public class KthLargestElmentInAnArray {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
		System.out.println(findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
	}

	private static int findKthLargest(int[] nums, int k) {
		return s2(nums, k);
	}

	private static int s1(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	private static int s2(int[] nums, int k) {
		int[] count = new int[20001];
		int offset = 10000;

		for (int i = 0; i < nums.length; i++) {
			count[nums[i] + offset]++;
		}

		int c = 0;
		for (int i = count.length - 1; i >= 0; i--) {
			if (c + count[i] >= k) {
				return i - offset;
			}

			c += count[i];

		}

		return 0;
	}
}
