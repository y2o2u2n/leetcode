package me.y2o2u2n.p650;

import java.util.Arrays;

/**
 * Created by JunSeok Youn on 2021-05-25
 */
public class TwoKeysKeyboard {

	public int minSteps(int n) {
		if (n == 1) {
			return 0;
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int num = 2; num <= n; num++) {
			int sqrt = (int)Math.sqrt(num);

			dp[num] = num;
			for (int i = sqrt; i <= num; i++) {
				if (num % i == 0) {
					int bigger = Math.min(dp[i], i);
					int smaller = num / i;
					dp[num] = Math.min(dp[num], bigger + smaller);
				}
			}
		}

		return dp[n];
	}
}
