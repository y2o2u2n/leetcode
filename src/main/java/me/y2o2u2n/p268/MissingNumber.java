package me.y2o2u2n.p268;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-17
 */
public class MissingNumber {
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] {3, 0, 1}));
		System.out.println(missingNumber(new int[] {0, 1}));
		System.out.println(missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
		System.out.println(missingNumber(
			new int[] {44, 26, 34, 25, 23, 42, 0, 43, 38, 14, 47, 19, 49, 6, 16, 41, 24, 35, 10, 4, 32, 5, 8, 15, 31, 3,
				46, 22, 2, 30, 28, 37, 1, 21, 39, 45, 9, 48, 36, 17, 7, 27, 18, 29, 13, 40, 11, 20, 12}
		));
	}

	private static int missingNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		for (int i = 0; i < nums.length + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		return -1;
	}
}
