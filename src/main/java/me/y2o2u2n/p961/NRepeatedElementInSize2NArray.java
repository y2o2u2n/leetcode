package me.y2o2u2n.p961;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-04-22
 */
public class NRepeatedElementInSize2NArray {

	public static void main(String[] args) {
		System.out.println(repeatedNTimes(new int[] {1, 2, 3, 3}));
		System.out.println(repeatedNTimes(new int[] {2, 1, 2, 5, 3, 2}));
	}

	private static int repeatedNTimes(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int a : A) {
			Integer count = map.get(a);
			map.put(a, count == null ? 1 : count + 1);
		}

		for (int a : map.keySet()) {
			Integer count = map.get(a);
			if (count == A.length / 2) {
				return a;
			}
		}

		return -1;
	}
}
