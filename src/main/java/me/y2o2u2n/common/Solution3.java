package me.y2o2u2n.common;

/**
 * Created by JunSeok Youn on 2021/08/29
 */
public class Solution3 {
	public int solution(int[] s) {
		boolean up = true;
		int count = 0;

		int prev = s[0];
		for (int i = 1; i < s.length; i++) {
			int curr = s[i];

			if (up) {
				if (!(prev < curr)) {
					count++;
					up = true;
				} else {
					up = false;
				}
			} else {
				if (!(prev > curr)) {
					count++;
					up = false;
				} else {
					up = true;
				}
			}

			prev = curr;
		}

		return count;
	}
}
