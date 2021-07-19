package me.y2o2u2n.p518;

public class CoinChange2 {
	public int change(int amount, int[] coins) {
		return s1(amount, coins);
	}

	private int s2(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int coin : coins) {
			for (int a = coin; a <= amount; a++) {
				dp[a] = dp[a] + dp[a - coin];
			}
		}

		return dp[amount];
	}

	private int s1(int amount, int[] coins) {
		int[][] dp = new int[coins.length][amount + 1];

		for (int c = 0; c < coins.length; c++) {
			dp[c][0] = 1;
			for (int a = 1; a <= amount; a++) {
				dp[c][a] += (c - 1 >= 0) ? dp[c - 1][a] : 0; // case1 : without current coin
				dp[c][a] += (a - coins[c] >= 0) ? dp[c][a - coins[c]] : 0; // case2 : with current coin
			}
		}

		return dp[coins.length - 1][amount];
	}
}
