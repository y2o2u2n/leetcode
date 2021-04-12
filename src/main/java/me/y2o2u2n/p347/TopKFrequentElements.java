package me.y2o2u2n.p347;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-04-12
 */
public class TopKFrequentElements {
	public static void main(String[] args) {
		// printArr(topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2));
		// printArr(topKFrequent(new int[] {1}, 1));
		printArr(topKFrequent(new int[] {4, 1, -1, 2, -1, 2, 3}, 2));
	}

	private static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			Integer count = map.get(num);
			count = count == null ? 0 : count;
			map.put(num, count + 1);
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

		int[] ret = new int[k];
		int i = 0;

		for (Map.Entry<Integer, Integer> entry : list) {
			if (i == k) {
				break;
			}

			ret[i++] = entry.getKey();
		}

		return ret;
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
