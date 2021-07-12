package me.y2o2u2n.p983;

public class MinimumCostForTickets {
	public int mincostTickets(int[] days, int[] costs) {
		boolean[] planned = new boolean[366];
		for (int day : days) {
			planned[day] = true;
		}

		int[] dp = new int[366];
		dp[0] = 0;

		for (int d = 1; d <= 365; d++) {
			if (!planned[d]) {
				dp[d] = dp[d - 1];
			} else {
				int min = Integer.MAX_VALUE;
				min = Math.min(min, dp[Math.max(0, d - 1)] + costs[0]);
				min = Math.min(min, dp[Math.max(0, d - 7)] + costs[1]);
				min = Math.min(min, dp[Math.max(0, d - 30)] + costs[2]);
				dp[d] = min;
			}
		}

		return dp[365];
	}
}
