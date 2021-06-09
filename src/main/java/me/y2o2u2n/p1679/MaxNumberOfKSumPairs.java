package me.y2o2u2n.p1679;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by JunSeok Youn on 2021/06/09
 */
public class MaxNumberOfKSumPairs {
	public int maxOperations(int[] nums, int k) {
		Map<Integer, Integer> map = new TreeMap<>();

		int ans = 0;

		for (int num : nums) {
			Integer count = map.getOrDefault(num, 0);
			if (count > 0) {
				map.put(num, count - 1);
				ans++;
			} else {
				map.put(k - num, map.getOrDefault(k - num, 0) + 1);
			}
		}

		return ans;
	}
}
