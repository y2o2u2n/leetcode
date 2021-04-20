package me.y2o2u2n.p318;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by JunSeok Youn on 2021-04-20
 */
public class MaximumProductOfWordLengths {
	public static void main(String[] args) {
		System.out.println(maxProduct(new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
		System.out.println(maxProduct(new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
		System.out.println(maxProduct(new String[] {"a", "aa", "aaa", "aaaa"}));

	}

	private static int maxProduct(String[] words) {
		return s2(words);
	}

	private static int s2(String[] words) {
		int max = Integer.MIN_VALUE;
		boolean doesAnswerExist = false;

		Map<String, Set<Character>> map = new HashMap<>();
		for (String word : words) {
			Set<Character> set = word.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
			map.put(word, set);
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				Set<Character> iChars = map.get(words[i]);
				Set<Character> jChars = map.get(words[j]);

				if (Collections.disjoint(iChars, jChars)) {
					doesAnswerExist = true;
					max = Math.max(max, words[i].length() * words[j].length());
				}

			}
		}

		return doesAnswerExist ? max : 0;
	}

	private static int s1(String[] words) {
		int max = Integer.MIN_VALUE;
		boolean doesAnswerExist = false;

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (!hasCommonLetters1(words[i], words[j])) {
					doesAnswerExist = true;
					max = Math.max(max, words[i].length() * words[j].length());
				}

			}
		}

		return doesAnswerExist ? max : 0;
	}

	private static boolean hasCommonLetters1(String a, String b) {
		for (char ch : a.toCharArray()) {
			if (b.contains(String.valueOf(ch))) {
				return true;
			}
		}

		return false;
	}

}
