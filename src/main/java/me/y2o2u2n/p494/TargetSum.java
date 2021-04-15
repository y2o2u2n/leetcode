package me.y2o2u2n.p494;

/**
 * Created by JunSeok Youn on 2021-04-15
 */
public class TargetSum {

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
		System.out.println(findTargetSumWays(new int[] {1}, 1));

	}

	private static int findTargetSumWays(int[] nums, int target) {
		return s1(nums, target);
	}

	private static int s1(int[] nums, int target) {
		return dfs(nums, nums.length, target, 0, 0);
	}

	private static int dfs(int[] nums, int n, int target, int depth, int current) {
		if (depth == n) {
			if (target == 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			int ret = 0;
			// minus
			ret += dfs(nums, n, target - nums[current], depth + 1, current + 1);
			// plus
			ret += dfs(nums, n, target + nums[current], depth + 1, current + 1);
			return ret;
		}
	}
}
