package me.y2o2u2n.p771;

public class JewelsAndStones {
	public int numJewelsInStones(String jewels, String stones) {
		boolean[] lowercase = new boolean['z' - 'a' + 1];
		boolean[] uppercase = new boolean['Z' - 'A' + 1];

		for (char jewel : jewels.toCharArray()) {
			if (jewel >= 'a' && jewel <= 'z') {
				lowercase[jewel - 'a'] = true;
			} else if (jewel >= 'A' && jewel <= 'Z') {
				uppercase[jewel - 'A'] = true;
			}
		}

		int count = 0;
		for (char stone : stones.toCharArray()) {
			if (stone >= 'a' && stone <= 'z') {
				count += lowercase[stone - 'a'] ? 1 : 0;
			} else if (stone >= 'A' && stone <= 'Z') {
				count += uppercase[stone - 'A'] ? 1 : 0;
			}

		}

		return count;
	}
}
