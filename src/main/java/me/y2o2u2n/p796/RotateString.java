package me.y2o2u2n.p796;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class RotateString {
	public boolean rotateString(String s, String goal) {
		return s2(s, goal);
	}

	private boolean s2(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		return (s + s).contains(goal);
	}

	private boolean s1(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		if (s.equals(goal)) {
			return true;
		}

		Queue<Character> queue = new LinkedList<>();
		for (char ch : s.toCharArray()) {
			queue.offer(ch);
		}

		int n = s.length();
		while (n-- > 0) {
			queue.offer(queue.poll());
			String collect = queue.stream()
				.map(Object::toString)
				.collect(Collectors.joining());

			if (collect.equals(goal)) {
				return true;
			}

		}

		return false;
	}
}
