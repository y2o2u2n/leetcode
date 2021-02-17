package me.y2o2u2n.p5;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(solve("aaaaa"));
	}

	private static String solve(String s) {
		char[] chars = s.toCharArray();
		int n = chars.length;
		boolean[][] dp = new boolean[n][n];
		int maxLength = 0;
		String maxStr = "";

		// p(i, i) = true
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
			maxLength = 1;
			maxStr = s.substring(i, i + 1);
		}

		// p (i, i + 1) = s(i) == s(i+1)
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				maxLength = 2;
				maxStr = s.substring(i, (i + 1) + 1);
			}
		}

		// p(i, j)
		// true, if the substring si, ... , sj is a palindrome
		// false, otherwise.

		// k : length of substring
		for (int k = 3; k <= n; k++) {
			// i : start index
			for (int i = 0; i < n - k + 1; i++) {
				// j : end index
				int j = i + k - 1;

				dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
				if (dp[i][j] && (j - i + 1) >= maxLength) {
					maxLength = j - i + 1;
					maxStr = s.substring(i, j + 1);
				}
			}

		}

		return maxStr;
	}
}
