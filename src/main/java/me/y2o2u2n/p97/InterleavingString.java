package me.y2o2u2n.p97;

/**
 * Created by JunSeok Youn on 2021-04-28
 */
public class InterleavingString {
	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(isInterleave("", "", ""));
		System.out.println(isInterleave("a", "b", "a"));
		System.out.println(isInterleave("aabc", "abad", "aabcabad"));
	}

	private static boolean isInterleave(String s1, String s2, String s3) {
		return s1(s1, s2, s3, 0, 0, 0, "");
	}

	// Time Limit Exceeded
	private static boolean s1(String s1, String s2, String s3, int i, int j, int k, String str) {
		if (k == s3.length()) {
			return s3.equals(str) && i == s1.length() && j == s2.length();
		} else {
			boolean ret = false;

			char c3 = s3.charAt(k);

			if (i < s1.length()) {
				char c1 = s1.charAt(i);
				if (c1 == c3) {
					ret = s1(s1, s2, s3, i + 1, j, k + 1, str + c1);
					if (ret) {
						return true;
					}
				}
			}

			if (j < s2.length()) {
				char c2 = s2.charAt(j);
				if (c2 == c3) {
					ret = s1(s1, s2, s3, i, j + 1, k + 1, str + c2);
					if (ret) {
						return true;
					}
				}
			}

			return ret;
		}
	}
}
