package me.y2o2u2n.p42;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-05-20
 */
public class TrappingRainWater {

	public int trap(int[] height) {
		return s2(height);
	}

	private int s2(int[] height) {
		int ans = 0;

		for (int i = 0; i < height.length; i++) {
			int leftMax = 0;
			int rightMax = 0;

			for (int j = i; j >= 0; j--) {
				leftMax = Math.max(leftMax, height[j]);
			}

			for (int j = i; j < height.length; j++) {
				rightMax = Math.max(rightMax, height[j]);
			}

			ans += Math.min(leftMax, rightMax) - height[i];

			System.out.println(Math.min(leftMax, rightMax) - height[i]);
		}

		System.out.println();

		return ans;
	}

	// Time Limit Exceeded
	private int s1(int[] height) {
		int ret = 0;
		int maxH = 0;

		for (int h : height) {
			maxH = Math.max(maxH, h);
		}

		for (int h = maxH; h >= 1; h--) {
			List<Integer> indexes = new ArrayList<>();
			for (int i = 0; i < height.length; i++) {
				if (height[i] >= h) {
					indexes.add(i);
				}
			}

			if (indexes.size() >= 2) {
				int last = indexes.get(indexes.size() - 1);
				int first = indexes.get(0);

				ret += (last - first - 1) - (indexes.size() - 2);
			}
		}

		return ret;
	}
}
