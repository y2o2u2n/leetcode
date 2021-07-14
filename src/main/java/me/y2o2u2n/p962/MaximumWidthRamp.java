package me.y2o2u2n.p962;

import java.util.Stack;

public class MaximumWidthRamp {
	public int maxWidthRamp(int[] nums) {
		return s2(nums);
	}

	private int s2(int[] nums) {
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
				stack.push(i);
			}
		}

		int max = 0;
		for (int j = n - 1; j >= 0; j--) {
			while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
				max = Math.max(max, j - stack.pop());
			}
		}

		return max;
	}

	// Time Limit Exceeded
	private int s1(int[] nums) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] <= nums[j]) {
					max = Math.max(max, j - i);
				}
			}
		}

		return max == Integer.MIN_VALUE ? 0 : max;
	}
}
