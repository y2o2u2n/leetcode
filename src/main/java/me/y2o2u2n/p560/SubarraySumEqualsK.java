package me.y2o2u2n.p560;

/**
 * Created by JunSeok Youn on 2021-04-15
 */
public class SubarraySumEqualsK {
	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] {1, 1, 1}, 2));
		System.out.println(subarraySum(new int[] {1, 2, 3}, 3));
		System.out.println(subarraySum(new int[] {1, 2, 0, 1, 2, 1, 2}, 3));
	}

	private static int subarraySum(int[] nums, int k) {
		return s1(nums, k);
	}

	private static int s1(int[] nums, int k) {
		int n = nums.length;
		int ret = 0;
		for (int i = 0; i < n; i++) {
			int sum = nums[i];
			if (sum == k) {
				ret++;
			}

			for (int j = i + 1; j < n; j++) {
				sum += nums[j];
				if (sum == k) {
					ret++;
				}
			}
		}

		return ret;
	}
}
