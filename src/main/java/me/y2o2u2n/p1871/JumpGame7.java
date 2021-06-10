package me.y2o2u2n.p1871;

/**
 * Created by JunSeok Youn on 2021/06/11
 */
public class JumpGame7 {
	public boolean canReach(String s, int minJump, int maxJump) {
		int n = s.length();
		boolean[] dp = new boolean[n];
		dp[0] = true;

		for (int i = 1; i < n; i++) {
			char c = s.charAt(i);

			if (c == '0') {
				for (int j = minJump; j <= maxJump; j++) {
					if ((i - j) >= 0 && (i - j) < n && dp[i - j]) {
						dp[i] = true;
						break;
					}
				}
			}
		}

		return dp[n - 1];
	}
}
