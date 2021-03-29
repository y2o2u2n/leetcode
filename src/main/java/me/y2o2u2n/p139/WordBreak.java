package me.y2o2u2n.p139;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-03-29
 */
public class WordBreak {
	public static void main(String[] args) {
		// System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
		// System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
		// System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
		System.out.println(wordBreak("cars", Arrays.asList("car", "ca", "rs")));
		System.out.println(wordBreak(
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
			Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
				"aaaaaaaaaa")));
	}

	private static boolean wordBreak(String s, List<String> wordDict) {
		return s2(s, wordDict);
	}

	private static boolean s1(String str, List<String> wordDict) {
		if (str.length() == 0) {
			return true;
		} else {
			for (int i = 0; i < wordDict.size(); i++) {
				String word = wordDict.get(i);
				if (str.length() < word.length()) {
					continue;
				}

				if (word.equals(str.substring(0, word.length()))) {
					boolean ret = s1(str.substring(word.length()), wordDict);
					if (ret) {
						return true;
					}
				}
			}

			return false;
		}
	}

	private static boolean s2(String str, List<String> wordDict) {
		boolean[] dp = new boolean[str.length() + 1];
		dp[0] = true;

		for (int i = 0; i < str.length(); i++) {
			if (!dp[i]) {
				continue;
			}

			for (String word : wordDict) {
				int len = word.length();
				int end = i + len;

				if (end > str.length()) {
					continue;
				}

				if (dp[end]) {
					continue;
				}

				if (str.substring(i, end).equals(word)) {
					dp[end] = true;
				}
			}
		}

		return dp[str.length()];
	}
}
