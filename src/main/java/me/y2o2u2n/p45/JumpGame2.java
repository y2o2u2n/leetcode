package me.y2o2u2n.p45;

/**
 * Created by JunSeok Youn on 2021-03-10
 */
public class JumpGame2 {
	public static void main(String[] args) {
		System.out.println(jump(new int[] {2, 3, 1, 1, 4}));
		System.out.println(jump(new int[] {2, 3, 0, 1, 4}));
	}

	private static int jump(int[] nums) {
		int length = nums.length;
		int[] dp = new int[length];

		dp[0] = 0;
		for (int i = 1; i < length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (nums[j] >= i - j) {
					min = Math.min(min, dp[j] + 1);
				}
			}

			dp[i] = min;
		}

		return dp[length - 1];
	}
}
