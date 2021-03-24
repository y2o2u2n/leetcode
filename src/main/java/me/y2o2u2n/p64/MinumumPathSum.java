package me.y2o2u2n.p64;

/**
 * Created by JunSeok Youn on 2021-03-24
 */
public class MinumumPathSum {
	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
		System.out.println(minPathSum(new int[][] {{1, 2, 3}, {4, 5, 6}}));
	}

	private static int minPathSum(int[][] grid) {
		int yLength = grid.length;
		int xLength = grid[0].length;
		int dp[][] = new int[yLength][xLength];

		dp[0][0] = grid[0][0];

		for (int j = 1; j < yLength; j++) {
			dp[j][0] = dp[j - 1][0] + grid[j][0];
		}

		for (int i = 1; i < xLength; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}

		for (int j = 1; j < yLength; j++) {
			for (int i = 1; i < xLength; i++) {
				dp[j][i] = Math.min(dp[j - 1][i], dp[j][i - 1]) + grid[j][i];
			}
		}

		return dp[yLength - 1][xLength - 1];
	}
}
