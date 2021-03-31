package me.y2o2u2n.p152;

/**
 * Created by JunSeok Youn on 2021-03-31
 */
public class MaximumProductSubarray {
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {2, 3, -2, 4})); // 6
		System.out.println(maxProduct(new int[] {-2, 0, -1})); // 0
		System.out.println(maxProduct(new int[] {-2})); // -2
		System.out.println(maxProduct(new int[] {0, 2})); // 2
		System.out.println(maxProduct(new int[] {-2, 3, -4})); // 24
	}

	private static int maxProduct(int[] nums) {
		return s2(nums);
	}

	private static int s1(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		int n = nums.length;
		int[][] m = new int[n][n];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			m[i][i] = nums[i];
			max = Math.max(max, m[i][i]);
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				m[i][j] = m[i][j - 1] * nums[j];
				max = Math.max(max, m[i][j]);
			}
		}

		return max;
	}

	private static int s2(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		int n = nums.length;
		int[] minM = new int[n];
		int[] maxM = new int[n];

		minM[0] = nums[0];
		maxM[0] = nums[0];

		for (int i = 1; i < n; i++) {
			maxM[i] = nums[i]; // 연속 되지 않는 경우
			maxM[i] = Math.max(maxM[i], maxM[i - 1] * nums[i]); // 연결 되는 경우,
			maxM[i] = Math.max(maxM[i], minM[i - 1] * nums[i]); // 연결 되는 경우,

			minM[i] = nums[i]; // 연속 되지 않는 경우
			minM[i] = Math.min(minM[i], minM[i - 1] * nums[i]); // 연결 되는 경우,
			minM[i] = Math.min(minM[i], maxM[i - 1] * nums[i]); // 연결 되는 경우,
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, maxM[i]);
		}

		return max;
	}

}
