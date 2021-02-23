package me.y2o2u2n.p28;

/**
 * Created by JunSeok Youn on 2021-02-23
 */
public class ImplementStrStr {
	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
		System.out.println(strStr("", ""));
		System.out.println(strStr("a", "a"));
	}

	private static int strStr(String haystack, String needle) {
		int hLength = haystack.length();
		int nLength = needle.length();

		if (needle.equals("")) {
			return 0;
		}

		for (int i = 0; i < hLength; i++) {
			if (hLength - i < nLength) {
				continue;
			}

			String substring = haystack.substring(i, i + nLength);
			if (substring.equals(needle)) {
				return i;
			}
		}

		return -1;
	}
}
