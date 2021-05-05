package me.y2o2u2n.p718;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by JunSeok Youn on 2021-05-05
 */
public class MaximumLengthOfRepeatedSubarray {
	public static void main(String[] args) {
		System.out.println(findLength(new int[] {1, 2, 3, 2, 1}, new int[] {3, 2, 1, 4, 7})); // 3
		System.out.println(findLength(new int[] {0, 0, 0, 0, 0}, new int[] {0, 0, 0, 0, 0})); // 5
		System.out.println(findLength(new int[] {0, 1, 1, 1, 1}, new int[] {1, 0, 1, 0, 1})); // 2
		System.out.println(findLength(new int[] {5, 14, 53, 80, 48}, new int[] {50, 47, 3, 80, 83})); // 1
	}

	private static int findLength(int[] nums1, int[] nums2) {
		return s2(nums1, nums2);
	}

	private static int s2(int[] nums1, int[] nums2) {
		int max = 0;

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int num1 = nums1[i];
				int num2 = nums2[j];

				if (num1 != num2) {
					continue;
				}

				int count = 1;
				int a = i;
				int b = j;

				while (a + 1 < nums1.length && b + 1 < nums2.length && nums1[a + 1] == nums2[b + 1]) {
					count++;
					a++;
					b++;
				}

				max = Math.max(max, count);
			}
		}

		return max;
	}

	// Time Limit Exceeded
	private static int s1(int[] nums1, int[] nums2) {
		Set<List<Integer>> set1 = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = i; j < nums1.length; j++) {
				int[] sub = Arrays.copyOfRange(nums1, i, j + 1);
				List<Integer> list = Arrays.stream(sub).boxed().collect(Collectors.toList());
				;
				set1.add(list);
			}
		}

		int max = 0;
		for (int i = 0; i < nums2.length; i++) {
			for (int j = i; j < nums2.length; j++) {
				int[] sub = Arrays.copyOfRange(nums2, i, j + 1);
				List<Integer> list = Arrays.stream(sub).boxed().collect(Collectors.toList());
				;
				if (set1.contains(list)) {
					max = Math.max(max, sub.length);
				}
			}
		}

		return max;
	}
}
