package me.y2o2u2n.p647;

/**
 * Created by JunSeok Youn on 2021-04-17
 */
public class PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("ab")); // 2
		System.out.println(countSubstrings("abc")); // 3
		System.out.println(countSubstrings("aaa")); // 6
		System.out.println(countSubstrings("abcba")); // 7
	}

	private static int countSubstrings(String s) {
		return s2(s);
	}

	private static int s2(String s) {
		int n = s.length();
		boolean[][] m = new boolean[n][n];
		int count = 0;

		for (int i = 0; i < n; i++) {
			m[i][i] = true;
			if (m[i][i]) {
				count++;
			}
		}

		for (int i = 0; i < n - 1; i++) {
			m[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			if (m[i][i+1]) {
				count++;
			}
		}

		for (int len = 3; len <= n; len++) {
			for (int i = 0, j = i + len - 1; j < n; i++, j++) {
				m[i][j] = m[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
				if (m[i][j]) {
					count++;
				}
			}
		}

		return count;
	}

	private static int s1(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String substr = s.substring(i, j + 1);
				count += isPalindrome(substr) ? 1 : 0;
			}
		}

		return count;
	}

	private static boolean isPalindrome(String s) {
		int length = s.length();
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) != s.charAt(length - i - 1)) {
				return false;
			}
		}

		return true;
	}
}
