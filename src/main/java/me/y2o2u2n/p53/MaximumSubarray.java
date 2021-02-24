package me.y2o2u2n.p53;

/**
 * Created by JunSeok Youn on 2021-02-24
 */
public class MaximumSubarray {
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		System.out.println(maxSubArray(new int[] {1}));
		System.out.println(maxSubArray(new int[] {0}));
		System.out.println(maxSubArray(new int[] {-1}));
		System.out.println(maxSubArray(new int[] {-100000}));
		System.out.println(maxSubArray(new int[] {-2, 1}));
	}

	private static int maxSubArray(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE;

		if (n == 1) {
			return nums[0];
		}


		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				max = Math.max(max, sum);
			}
		}

		return max;
	}
}
