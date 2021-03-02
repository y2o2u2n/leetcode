package me.y2o2u2n.p136;

import java.util.HashSet;

/**
 * Created by JunSeok Youn on 2021-03-02
 */
public class SingleNumber {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {2, 2, 1}));
		System.out.println(singleNumber(new int[] {4, 1, 2, 1, 2}));
		System.out.println(singleNumber(new int[] {1}));
	}

	private static int singleNumber(int[] nums) {
		return s2(nums);
	}

	private static int s1(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				set.remove(num);
			} else {
				set.add(num);
			}
		}

		int i = 0;
		int singleNumber = 0;
		for (Integer num : set) {
			if (i == 1) {
				break;
			}

			singleNumber = num;

			i++;
		}

		return singleNumber;
	}

	private static int s2(int[] nums) {
		int ret = 0;
		for (int num : nums) {
			ret ^= num;
		}

		return ret;
	}
}
