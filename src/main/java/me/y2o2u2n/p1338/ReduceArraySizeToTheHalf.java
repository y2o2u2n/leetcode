package me.y2o2u2n.p1338;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021/06/30
 */
public class ReduceArraySizeToTheHalf {
	public int minSetSize(int[] arr) {
		Map<Integer, Integer> countByNumber = new HashMap<>();
		for (int num : arr) {
			Integer count = countByNumber.getOrDefault(num, 0);
			countByNumber.put(num, count + 1);
		}

		List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(countByNumber.entrySet());
		entries.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

		int n = arr.length;
		int ans = 0;
		int countSum = 0;
		for (Map.Entry<Integer, Integer> entry : entries) {
			Integer count = entry.getValue();

			ans++;
			countSum += count;

			if (countSum >=  n / 2) {
				break;
			}
		}

		return ans;
	}
}
