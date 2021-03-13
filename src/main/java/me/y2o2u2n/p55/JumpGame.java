package me.y2o2u2n.p55;

/**
 * Created by JunSeok Youn on 2021-03-13
 */
public class JumpGame {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] {2, 3, 1, 1, 4}));
		System.out.println(canJump(new int[] {3, 2, 1, 0, 4}));
		System.out.println(canJump(new int[] {2, 0, 0}));
	}

	private static boolean canJump(int[] nums) {
		int n = nums.length;
		boolean[] dp = new boolean[n];
		dp[0] = true;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i && !dp[i]; j++) {
				dp[i] = dp[j] && nums[j] >= (i - j);
			}
		}

		return dp[n - 1];
	}
}
