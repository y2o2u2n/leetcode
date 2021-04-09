package me.y2o2u2n.p300;

/**
 * Created by JunSeok Youn on 2021-04-09
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
		System.out.println(lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3}));
		System.out.println(lengthOfLIS(new int[] {7, 7, 7, 7, 7, 7, 7}));
		System.out.println(lengthOfLIS(new int[] {4, 10, 4, 3, 8, 9}));
		System.out.println(lengthOfLIS(new int[] {1, 3, 6, 7, 9, 4, 10, 5, 6}));
	}

	private static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n]; // length
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					max = Math.max(max, dp[j]);
				}
			}

			dp[i] = max + 1;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
