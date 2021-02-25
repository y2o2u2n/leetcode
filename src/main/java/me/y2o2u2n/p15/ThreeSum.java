package me.y2o2u2n.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-02-25
 */
public class ThreeSum {

	public static void main(String[] args) {
		printListList(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
		printListList(threeSum(new int[] {}));
		printListList(threeSum(new int[] {0}));

	}

	private static List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return List.of();
		}

		Arrays.sort(nums);

		Set<List<Integer>> ret = new HashSet<>();

		for (int i = 0; i < n; i++) {
			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum == 0) {
					ret.add(List.of(nums[i], nums[left], nums[right]));
					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return new ArrayList<>(ret);
	}

	private static void printListList(List<List<Integer>> threeSum) {
		for (List<Integer> list : threeSum) {
			for (int i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
