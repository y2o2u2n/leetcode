package me.y2o2u2n.p14;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"flower", "flow", "flight"};

		String ret = solve(strs);

		System.out.println(ret);

	}

	private static String solve(String[] strs) {
		int size = strs.length;

		if (size == 0) {
			return "";
		}

		if (size == 1) {
			return strs[0];
		}

		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			if (minValue > str.length()) {
				minValue = str.length();
				minIndex = i;
			}
		}

		String ret = "";
		boolean isSame = true;
		String shortestStr = strs[minIndex];
		for (int i = 0; i < shortestStr.length() && isSame; i++) {
			char ch = shortestStr.charAt(i);
			for (int j = 0; j < strs.length; j++) {
				String str = strs[j];
				if (ch != str.charAt(i)) {
					isSame = false;
				}
			}

			if (isSame) {
				ret += ch;
			}
		}
		return ret;
	}
}
