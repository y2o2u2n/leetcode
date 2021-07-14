package me.y2o2u2n.p1529;

public class BulbSwitcher4 {
	public int minFlips(String target) {
		char prev = target.charAt(0);
		int ans = prev == '1' ? 1 : 0;

		for (int i = 1; i < target.length(); i++) {
			char current = target.charAt(i);
			if (prev != current) {
				ans++;
			}
			prev = current;
		}

		return ans;
	}
}
