package me.y2o2u2n.p16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-02-25
 */
public class ThreeSumClosest {
	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1));

	}

	private static int threeSumClosest(int[] nums, int target) {
		int n = nums.length;

		Arrays.sort(nums);

		int min = Integer.MAX_VALUE;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				int distance = sum - target;
				if (min > Math.abs(distance)) {
					min = Math.abs(distance);
					ans = sum;
				}

				if (distance == 0) {
					return target;
				} else if (distance < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return ans;
	}
}
