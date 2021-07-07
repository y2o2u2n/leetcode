package me.y2o2u2n.p915;

public class PartitionArrayInToDisjointIntervals {

	public int partitionDisjoint(int[] nums) {
		// max(left) <= min(right)
		int[] maxLeft = new int[nums.length];
		int[] minRight = new int[nums.length];

		maxLeft[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
		}

		minRight[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			minRight[i] = Math.min(minRight[i + 1], nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			if (maxLeft[i] <= minRight[i + 1]) {
				return i + 1;
			}
		}

		return -1;
	}
}
