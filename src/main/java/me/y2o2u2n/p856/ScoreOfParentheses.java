package me.y2o2u2n.p856;

import java.util.Stack;

/**
 * Created by JunSeok Youn on 2021-04-30
 */
public class ScoreOfParentheses {

	public static void main(String[] args) {
		System.out.println(scoreOfParentheses("()")); // 1
		System.out.println(scoreOfParentheses("(())")); // 2
		System.out.println(scoreOfParentheses("()()")); // 2
		System.out.println(scoreOfParentheses("(()(()))")); // 6
	}

	private static int scoreOfParentheses(String S) {
		Stack<String> stack = new Stack<>();

		char[] chars = S.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (ch == '(') {
				stack.push("(");
			} else if (ch == ')') {
				String peek = stack.peek();
				if (peek.equals("(")) {
					stack.pop();
					stack.push("1");
				} else if (isNumeric(peek)) {
					String numStr = stack.pop();
					stack.pop(); // left
					stack.push(String.valueOf(Integer.parseInt(numStr) * 2));
				}

				if (stack.size() >= 2) {
					String numStr1 = stack.pop();
					String peek1 = stack.peek();

					if (isNumeric(peek1)) {
						String numStr2 = stack.pop();
						stack.push(String.valueOf(Integer.parseInt(numStr1) + Integer.parseInt(numStr2)));
					} else {
						stack.push(numStr1);
					}
				}
			}
		}

		return Integer.parseInt(stack.pop());
	}

	private static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
