package me.y2o2u2n.p96;

/**
 * Created by JunSeok Youn on 2021-03-25
 */
public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(3));
		System.out.println(numTrees(1));
	}

	private static int numTrees(int n) {
		return s1(n);
	}

	private static int s1(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				dp[i] += dp[j - 1] * dp[i - j];
		}
		return dp[n];
	}
}
