package me.y2o2u2n.p209;

/**
 * Created by JunSeok Youn on 2021-06-16
 */
public class MinimumSizeSubArraySum {
	public int minSubArrayLen(int target, int[] nums) {
		return s3(target, nums);
	}

	private int s3(int target, int[] nums) {
		int start = 0;
		int end = 0;
		int sum = nums[0];
		int ans = Integer.MAX_VALUE;
		int n = nums.length;

		while (true) {
			if (sum >= target) {
				ans = Math.min(ans, end - start + 1);
			}

			if ((start == n - 1 && end == n - 1) || (end == n - 1 && sum < target)) {
				break;
			}

			if (sum < target && end < n - 1) {
				end++;
				sum += nums[end];
			} else if (sum >= target && start < n - 1) {
				sum -= nums[start];
				start++;
			}
		}

		return ans != Integer.MAX_VALUE ? ans : 0;
	}

	// Time Limit Exceeded - O(n^2)
	private int s2(int target, int[] nums) {
		int n = nums.length;

		int[][] sum = new int[n][n];

		for (int i = 0; i < n; i++) {
			sum[i][i] = nums[i];
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				sum[i][j] = sum[i][j - 1] + nums[j];
			}
		}

		int ans = Integer.MAX_VALUE;

		for (int length = 1; length <= n; length++) {
			for (int start = 0; start < n; start++) {
				int end = start + length - 1;
				if (end >= n) {
					continue;
				}

				if (sum[start][end] >= target) {
					ans = Math.min(ans, length);
				}
			}
		}

		return ans != Integer.MAX_VALUE ? ans : 0;
	}

	// Time Limit Exceeded - O(n^3)
	private int s1(int target, int[] nums) {
		int n = nums.length;
		int ans = Integer.MAX_VALUE;

		for (int length = 1; length <= n; length++) {
			for (int start = 0; start < n; start++) {
				int end = start + length - 1;
				if (end >= n) {
					continue;
				}

				int sum = 0;
				for (int i = start; i <= end; i++) {
					sum += nums[i];
				}

				if (sum >= target) {
					ans = Math.min(ans, length);
				}
			}
		}

		return ans != Integer.MAX_VALUE ? ans : 0;
	}
}
