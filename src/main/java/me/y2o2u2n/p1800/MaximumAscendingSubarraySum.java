package me.y2o2u2n.p1800;

/**
 * Created by JunSeok Youn on 2021-05-25
 */
public class MaximumAscendingSubarraySum {

	public int maxAscendingSum(int[] nums) {
		int ans = 0;
		int prev = nums[0];
		int sum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int current = nums[i];
			if (prev < current) {
				sum += nums[i];
			} else {
				ans = Math.max(ans, sum);
				sum = nums[i];
			}

			prev = current;
		}

		return Math.max(ans, sum);
	}
}
