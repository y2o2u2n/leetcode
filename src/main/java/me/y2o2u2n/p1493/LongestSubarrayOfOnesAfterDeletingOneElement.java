package me.y2o2u2n.p1493;

/**
 * Created by JunSeok Youn on 2021/07/02
 */
public class LongestSubarrayOfOnesAfterDeletingOneElement {
	public int longestSubarray(int[] nums) {
		int length = nums.length;

		if (equalsAll(nums, 0 )) {
			return 0;
		} else if (equalsAll(nums, 1)) {
			return length - 1;
		}

		int[] countOfOnes = new int[length];

		int countOfOne = 0;
		for (int i = 0; i < length; i++) {
			int num = nums[i];
			if (num == 1) {
				countOfOne++;
			}

			if (i == length - 1) {
				int j = i;

				while (j >= 0 && nums[j] == 1) {
					countOfOnes[j] = countOfOne;
					j--;
				}
			}

			if (num == 0) {
				int j = i - 1;

				while (j >= 0 && nums[j] == 1) {
					countOfOnes[j] = countOfOne;
					j--;
				}

				countOfOne = 0;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < countOfOnes.length; i++) {
			int count = countOfOnes[i];
			if (count == 0) {
				int temp = 0; // left + right
				if (i - 1 >= 0)
					temp += countOfOnes[i - 1];
				if (i + 1 < countOfOnes.length)
					temp += countOfOnes[i + 1];
				max = Math.max(max, temp);
			}
		}

		return max;
	}

	private boolean equalsAll(int[] arr, int target) {
		for (int val : arr) {
			if (val != target) {
				return false;
			}
		}
		return true;
	}
}
