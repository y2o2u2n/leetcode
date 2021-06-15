package me.y2o2u2n.p896;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
public class MonotonicArray {
	public boolean isMonotonic(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return true;
		}

		return isMonotonicIncreasing(nums) || isMonotonicDecreasing(nums);
	}

	private boolean isMonotonicIncreasing(int[] nums) {
		int prev = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int current = nums[i];
			if (prev > current) {
				return false;
			}
			prev = current;
		}

		return true;
	}

	private boolean isMonotonicDecreasing(int[] nums) {
		int prev = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int current = nums[i];
			if (prev < current) {
				return false;
			}
			prev = current;
		}

		return true;
	}
}
