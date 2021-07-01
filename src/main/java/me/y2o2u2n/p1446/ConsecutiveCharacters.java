package me.y2o2u2n.p1446;

/**
 * Created by JunSeok Youn on 2021/07/01
 */
public class ConsecutiveCharacters {
	public int maxPower(String s) {
		int ans = 1;
		int count = 1;
		char prev = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			char current = s.charAt(i);
			if (current == prev) {
				count++;
				ans = Math.max(ans, count);
			} else {
				count = 1;
			}
			prev = current;
		}

		return ans;
	}
}
