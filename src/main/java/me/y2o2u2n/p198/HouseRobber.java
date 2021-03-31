package me.y2o2u2n.p198;

/**
 * Created by JunSeok Youn on 2021-03-31
 */
public class HouseRobber {
	public static void main(String[] args) {
		System.out.println(rob(new int[] {1, 2, 3, 1})); // 4
		System.out.println(rob(new int[] {2, 7, 9, 3, 1})); // 12
	}

	private static int rob(int[] nums) {
		int n = nums.length;

		if (n == 1) {
			return nums[0];
		}

		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] m = new int[n];
		m[0] = nums[0];
		m[1] = Math.max(nums[1], m[0]);

		for (int i = 2; i < n; i++) {
			m[i] = Math.max(m[i - 2] + nums[i], m[i - 1]);
		}

		return m[n - 1];
	}
}
