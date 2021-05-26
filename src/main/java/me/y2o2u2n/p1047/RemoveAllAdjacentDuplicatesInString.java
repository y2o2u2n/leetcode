package me.y2o2u2n.p1047;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by JunSeok Youn on 2021-05-26
 */
public class RemoveAllAdjacentDuplicatesInString {
	public String removeDuplicates(String s) {
		Deque<Character> deque = new LinkedList<>();

		for (Character c : s.toCharArray()) {
			if (deque.isEmpty()) {
				deque.offer(c);
			} else if (deque.peekLast() == c) {
				deque.pollLast();
			} else {
				deque.offer(c);
			}
		}

		StringBuilder builder = new StringBuilder();
		for (Character ch : deque) {
			builder.append(ch);
		}

		return builder.toString();
	}
}
