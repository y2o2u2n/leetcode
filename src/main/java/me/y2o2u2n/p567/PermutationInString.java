package me.y2o2u2n.p567;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-05-13
 */
public class PermutationInString {
	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));
		System.out.println(checkInclusion("adc", "dcda"));
	}

	private static boolean checkInclusion(String s1, String s2) {
		return s2(s1, s2);
	}

	private static boolean s2(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}

		int[] f1 = new int['z' - 'a' + 1];

		for (int i = 0; i < s1.length(); i++) {
			f1[s1.charAt(i) - 'a']++;
		}

		for (int start = 0; start < s2.length() - s1.length() + 1; start++) {
			int end = start + s1.length();
			String substr = s2.substring(start, end);
			System.out.println(substr);

			int[] fSubstr = new int['z' - 'a' + 1];
			for (int i = 0; i < substr.length(); i++) {
				fSubstr[substr.charAt(i) - 'a']++;
			}

			if (isEqual(f1, fSubstr)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isEqual(int[] f1, int[] f2) {
		for (int i = 0; i < 'z' - 'a'; i++) {
			if (f1[i] != f2[i]) {
				return false;
			}
		}

		return true;
	}

	// Time Limit Exceeded
	private static boolean s1(String s1, String s2) {
		Set<String> cases = new HashSet<>();
		boolean[] visited = new boolean[s1.length()];
		perm(s1, visited, "", cases);

		boolean ret = false;
		for (String c : cases) {
			if (s2.contains(c)) {
				ret = true;
			}
		}

		return ret;
	}

	private static void perm(String s, boolean[] visited, String c, Set<String> cases) {
		if (c.length() == s.length()) {
			cases.add(c);
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (!visited[i]) {
					visited[i] = true;
					perm(s, visited, c + s.charAt(i), cases);
					visited[i] = false;
				}
			}
		}
	}
}
