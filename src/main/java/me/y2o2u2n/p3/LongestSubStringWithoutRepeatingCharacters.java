package me.y2o2u2n.p3;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "abcabcbb";

		int solve = solve(s);

		System.out.println(solve);
	}

	private static int solve(String s) {
		Set<Character> set = new HashSet<>();
		int n = s.length();
		int start = 0;
		int end = 0;
		int ans = 0;

		while (end < n) {
			if (set.contains(s.charAt(end))) {
				set.remove(s.charAt(start++));
			} else {
				set.add(s.charAt(end++));
				ans = Math.max(ans, end - start);
			}
		}

		return ans;
	}
}
