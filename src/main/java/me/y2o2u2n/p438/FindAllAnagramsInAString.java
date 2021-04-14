package me.y2o2u2n.p438;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-14
 */
public class FindAllAnagramsInAString {
	public static void main(String[] args) {
		printList(findAnagrams("cbaebabacd", "abc"));
		printList(findAnagrams("abab", "ab"));
		printList(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
	}

	private static List<Integer> findAnagrams(String s, String p) {
		return s2(s, p);
	}

	private static List<Integer> s2(String s, String p) {
		int[] pCount = new int['z' - 'a' + 1];
		for (char ch : p.toCharArray()) {
			pCount[ch - 'a']++;
		}

		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i <= s.length() - p.length(); i++) {
			String substr = s.substring(i, i + p.length());

			int[] subStrCount = new int['z' - 'a' + 1];
			for (char ch : substr.toCharArray()) {
				subStrCount[ch - 'a']++;
			}

			if (isEqual(pCount, subStrCount, 'z' - 'a' + 1)) {
				ret.add(i);
			}
		}

		return ret;
	}

	private static boolean isEqual(int[] a, int[] b, int n) {
		for (int i = 0; i < n; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}

		return true;
	}

	// Time Limit Exceeded
	private static List<Integer> s1(String s, String p) {
		if (s.length() < p.length()) {
			return List.of();
		}

		boolean[] visited = new boolean[p.length()];
		Set<String> anagrams = new HashSet<>();
		anagram(p, "", 0, visited, anagrams);

		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i <= s.length() - p.length(); i++) {
			String substr = s.substring(i, i + p.length());
			if (anagrams.contains(substr)) {
				ret.add(i);
			}
		}

		return ret;
	}

	private static void anagram(String word, String str, int current, boolean[] visited, Set<String> anagrams) {
		if (current == word.length()) {
			// System.out.println(str);
			anagrams.add(str);
		} else {
			for (int i = 0; i < word.length(); i++) {
				if (visited[i]) {
					continue;
				}

				visited[i] = true;
				char ch = word.charAt(i);
				anagram(word, str + ch, current + 1, visited, anagrams);
				visited[i] = false;
			}
		}
	}

	private static void printList(List<Integer> list) {
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
