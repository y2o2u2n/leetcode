package me.y2o2u2n.p13;

public class RomanToInteger {

	public static void main(String[] args) {
		String s = "MCMXCIV";

		int ret = 0;
		int len = s.length();
		char c;

		for (int i = len - 1; i >= 0; i--) {
			c = s.charAt(i);

			if (c == 'I') {
				ret += (ret >= 5 || ret >= 10) ? -1 : 1;
			} else if (c == 'V') {
				ret += 5;
			} else if (c == 'X') {
				ret += (ret >= 50 || ret >= 100) ? -10 : 10;
			} else if (c == 'L') {
				ret += 50;
			} else if (c == 'C') {
				ret += (ret >= 500 || ret >= 1000) ? -100 : 100;
			} else if (c == 'D') {
				ret += 500;
			} else if (c == 'M') {
				ret += 1000;
			}
		}

		System.out.println(ret);
	}
}
