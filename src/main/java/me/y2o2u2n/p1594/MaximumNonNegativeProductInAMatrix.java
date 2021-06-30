package me.y2o2u2n.p1594;

/**
 * Created by JunSeok Youn on 2021/06/30
 */
public class MaximumNonNegativeProductInAMatrix {
	public int maxProductPath(int[][] grid) {
		int yLength = grid.length;
		int xLength = grid[0].length;

		long[][][] dp = new long[yLength][xLength][2];
		dp[0][0][0] = grid[0][0];
		dp[0][0][1] = grid[0][0];

		for (int k = 1; k <= xLength + yLength - 2; k++) {
			for (int x = 0; x <= k; x++) {
				int y = k - x;
				if (y < yLength && x < xLength) {
					// System.out.print( grid[y][x] + " " );

					long max = Long.MIN_VALUE;
					long min = Long.MAX_VALUE;

					if (y - 1 >= 0)
						max = Math.max(max, (dp[y - 1][x][0] * grid[y][x]));
					if (y - 1 >= 0)
						max = Math.max(max, (dp[y - 1][x][1] * grid[y][x]));
					if (x - 1 >= 0)
						max = Math.max(max, (dp[y][x - 1][0] * grid[y][x]));
					if (x - 1 >= 0)
						max = Math.max(max, (dp[y][x - 1][1] * grid[y][x]));
					if (y - 1 >= 0)
						min = Math.min(min, (dp[y - 1][x][0] * grid[y][x]));
					if (y - 1 >= 0)
						min = Math.min(min, (dp[y - 1][x][1] * grid[y][x]));
					if (x - 1 >= 0)
						min = Math.min(min, (dp[y][x - 1][0] * grid[y][x]));
					if (x - 1 >= 0)
						min = Math.min(min, (dp[y][x - 1][1] * grid[y][x]));

					dp[y][x][0] = max;
					dp[y][x][1] = min;
				}
			}
			// System.out.println();
		}

		long max = dp[yLength - 1][xLength - 1][0];
		return max >= 0 ? (int)(max % (1_000_000_000 + 7)) : -1;
	}
}
