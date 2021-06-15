package me.y2o2u2n.p875;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
public class SumOfAbsoluteDifferencesInASortedArray {
	public int[] getSumAbsoluteDifferences(int[] nums) {
		return s2(nums);
	}

	private int[] s2(int[] nums) {
		int length = nums.length;

		int[] front = new int[length];
		front[0] = nums[0];
		for (int i = 1; i < length; i++) {
			front[i] = front[i - 1] + nums[i];
		}

		int[] back = new int[length];
		back[length - 1] = nums[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			back[i] = back[i + 1] + nums[i];
		}

		int[] ans = new int[length];
		for (int i = 0; i < length; i++) {
			int left = i;
			int right = length - i - 1;
			ans[i] = back[i] - front[i] - nums[i] * (right - left);
		}

		return ans;
	}

	// Time Limit Exceeded
	private int[] s1(int[] nums) {
		int[] ans = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int temp = 0;
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					System.out.print(Math.abs(nums[i] - nums[j]) + " ");
					temp += Math.abs(nums[i] - nums[j]);
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println(temp);
			ans[i] = temp;
		}

		return ans;
	}
}
