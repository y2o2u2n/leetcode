package me.y2o2u2n.p70;

/**
 * Created by JunSeok Youn on 2021-02-26
 */
public class ClimbingStairs {
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
	}

	// ()
	// (1)
	// (1, 1), (2)
	// (1, 1, 1), (1, 2), (2, 1)
	// (1, 1, 1, 1), (1, 2, 1), (2, 1, 1), (1, 1, 2), (2, 2)
	private static int climbStairs(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}
}
