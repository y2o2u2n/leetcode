package me.y2o2u2n.p287;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-09
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] {1, 3, 4, 2, 2}));

	}

	private static int findDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (set.contains(num)) {
				return num;
			} else {
				set.add(num);
			}
		}

		return -1;
	}
}
