package me.y2o2u2n.p1749;

/**
 * @link https://en.wikipedia.org/wiki/Maximum_subarray_problem
 */
public class MaximumAbsoluteSumOfAnySubarray {
	public int maxAbsoluteSum(int[] nums) {
		return s2(nums);
	}

	private int s2(int[] nums) {
		int length = nums.length;

		if (length == 0) {
			return 0;
		}

		int[] max = new int[length];
		max[0] = nums[0];

		for (int i = 1; i < length; i++) {
			max[i] = Math.max(max[i - 1] + nums[i], nums[i]);
		}

		int[] min = new int[length];
		min[0] = nums[0];

		for (int i = 1; i < length; i++) {
			min[i] = Math.min(min[i - 1] + nums[i], nums[i]);
		}

		int ans = 0;

		for (int m : max) {
			ans = Math.max(ans, Math.abs(m));
		}

		for (int m : min) {
			ans = Math.max(ans, Math.abs(m));
		}

		return ans;
	}

	private int s1(int[] nums) {
		int length = nums.length;
		int max = 0;

		if (length == 0) {
			return 0;
		}

		for (int start = 0; start < length; start++) {
			for (int end = start; end < length; end++) {
				int temp = 0;

				for (int i = start; i <= end; i++) {
					temp += nums[i];
				}

				max = Math.max(max, Math.abs(temp));
			}
		}

		return max;
	}
}
