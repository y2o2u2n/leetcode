package me.y2o2u2n.p350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-04-15
 */
public class IntersectionOfTowArrays2 {
	public static void main(String[] args) {
		printArr(intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
		printArr(intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}));
		printArr(intersect(new int[] {2, 1}, new int[] {1, 2}));


	}

	private static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();

		for (int i : nums1) {
			Integer count = map1.get(i);
			map1.put(i, count == null ? 1 : count + 1);
		}

		for (int i : nums2) {
			Integer count = map2.get(i);
			map2.put(i, count == null ? 1 : count + 1);
		}

		List<Integer> ret = new ArrayList<>();

		for (int num : map1.keySet()) {
			int num1Count = map1.get(num);
			int num2Count = map2.get(num) == null ? 0 : map2.get(num);

			int min = Math.min(num1Count, num2Count);
			for (int i = 0; i < min; i++) {
				ret.add(num);
			}
		}

		return ret.stream().mapToInt(i -> i).toArray();

	}

	private static void printArr(int[] arr) {
		if (arr == null) {
			return;
		}

		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}

}
