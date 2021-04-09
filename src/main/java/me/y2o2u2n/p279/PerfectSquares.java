package me.y2o2u2n.p279;

import java.util.Arrays;

/**
 * Created by JunSeok Youn on 2021-04-09
 */
public class PerfectSquares {
	public static void main(String[] args) {
		System.out.println(numSquares(12));
		System.out.println(numSquares(13));
	}

	private static int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);

			}
		}

		return dp[n];
	}
}
