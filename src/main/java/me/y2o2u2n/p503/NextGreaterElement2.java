package me.y2o2u2n.p503;

import java.util.Arrays;

/**
 * Created by JunSeok Youn on 2021/06/09
 */
public class NextGreaterElement2 {
	public int[] nextGreaterElements(int[] nums) {
		int[] ans = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int[] first = Arrays.copyOfRange(nums, i + 1, nums.length);
			int[] second = Arrays.copyOfRange(nums, 0, i);
			int[] merged = new int[first.length + second.length];

			System.arraycopy(first, 0, merged, 0, first.length);
			System.arraycopy(second, 0, merged, first.length, second.length);

			int next = Integer.MAX_VALUE;

			for (int val : merged) {
				if (nums[i] < val) {
					next = val;
					break;
				}
			}

			if (next == Integer.MAX_VALUE) {
				next = -1;
			}

			ans[i] = next;
		}

		return ans;
	}
}
