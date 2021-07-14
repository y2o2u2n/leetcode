package me.y2o2u2n.p1913;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductDifferenceBetweenTwoPairs {

	public int maxProductDifference(int[] nums) {
		List<Integer> numList = new ArrayList<>();
		for (int num : nums) {
			numList.add(num);
		}

		numList.sort((o1, o2) -> o2 - o1);
		int a = numList.get(0);
		int b = numList.get(1);
		numList.sort((o1, o2) -> o1 - o2);
		int c = numList.get(0);
		int d = numList.get(1);

		return a * b - c * d;
	}
}
