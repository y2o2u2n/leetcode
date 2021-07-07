package me.y2o2u2n.p678;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParenthesisString {
	public boolean checkValidString(String s) {
		int n = s.length();
		if (n == 0) {
			return true;
		}

		boolean[][] dp = new boolean[n][n]; // dp[i][j] = substr from i to j is valid

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '*')
				dp[i][i] = true;
			if (i < n - 1 &&
				(s.charAt(i) == '(' || s.charAt(i) == '*') &&
				(s.charAt(i + 1) == ')' || s.charAt(i + 1) == '*')) {
				dp[i][i + 1] = true;
			}
		}

		for (int size = 2; size < n; size++) {
			for (int i = 0; i + size < n; i++) {
				if (s.charAt(i) == '*' && dp[i + 1][i + size]) {
					dp[i][i + size] = true;
				} else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
					for (int k = i + 1; k <= i + size; k++) {
						if ((s.charAt(k) == ')' || s.charAt(k) == '*') &&
							(k == i + 1 || dp[i + 1][k - 1]) &&
							(k == i + size || dp[k + 1][i + size])) {
							dp[i][i + size] = true;
						}
					}
				}
			}
		}

		return dp[0][n - 1];
	}

	// Time Limit Exceeded
	private boolean s1(String s) {
		List<String> candidates = makeCandidates(s);

		for (String candidate : candidates) {
			if (isValid(candidate)) {
				return true;
			}
		}

		return false;
	}

	private List<String> makeCandidates(String origin) {
		List<String> candidates = new ArrayList<>();
		makeCandidate(origin, "", candidates, 0);
		return candidates;
	}

	private void makeCandidate(String origin, String candidate, List<String> candidates, int index) {
		StringBuilder sb = new StringBuilder(candidate);
		while (index < origin.length() && origin.charAt(index) != '*') {
			sb.append(origin.charAt(index));
			index++;
		}
		candidate = sb.toString();

		if (origin.length() == index) {
			candidates.add(candidate);
			return;
		}

		makeCandidate(origin, candidate + '(', candidates, index + 1);
		makeCandidate(origin, candidate + ')', candidates, index + 1);
		makeCandidate(origin, candidate, candidates, index + 1);
	}

	private boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				if (stack.peek() == '(' && c == ')') {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}

		return stack.isEmpty();
	}
}