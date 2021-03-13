package me.y2o2u2n.p62;

/**
 * Created by JunSeok Youn on 2021-03-13
 */
public class UniquePaths {
	private static int count = 0;

	public static void main(String[] args) {
		System.out.println(uniquePath(3, 7));
		System.out.println(uniquePath(3, 2));
		System.out.println(uniquePath(7, 3));
		System.out.println(uniquePath(3, 3));
		System.out.println(uniquePath(23, 12));
	}

	private static int uniquePath(int m, int n) {
		return s2(m, n);
	}

	private static int s2(int m, int n) {
		int[][] dp = new int[m + 1][n + 1];

		for (int j = 1; j <= m; j++) {
			for (int i = 1; i <= n; i++) {
				if (i == 1 || j == 1) {
					dp[j][i] = 1;
					continue;
				}

				int down = j > 1 ? dp[j - 1][i] : 0;
				int left = i > 1 ? dp[j][i - 1] : 0;
				dp[j][i] = down + left;
			}
		}

		return dp[m][n];
	}

	private static int s1(int m, int n) {
		count = 0;
		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;
		visit(visited, m, n, 0, 0);
		return count;
	}

	private static void visit(boolean[][] visited, int m, int n, int y, int x) {
		if (y == m - 1 && x == n - 1) {
			count++;
		} else {
			for (int j = 0; j <= 1; j++) {
				int i = 1 - j;

				if (y + j > m - 1
					|| x + i > n - 1
					|| y + j < 0
					|| x + i < 0
					|| visited[y + j][x + i]) {
					continue;
				}

				visited[y + j][x + i] = true;
				visit(visited, m, n, y + j, x + i);
				visited[y + j][x + i] = false;
			}
		}
	}

}

