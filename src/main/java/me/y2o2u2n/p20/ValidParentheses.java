package me.y2o2u2n.p20;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(solve("()[]{}"));
	}

	private static boolean solve(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(c);
				}
			} else if (c == '{') {
				stack.push(c);
			} else if (c == '}') {
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(c);
				}
			} else if (c == '[') {
				stack.push(c);
			} else if (c == ']') {
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}

		return stack.isEmpty();
	}
}
