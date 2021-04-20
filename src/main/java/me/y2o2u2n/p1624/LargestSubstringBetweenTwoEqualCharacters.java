package me.y2o2u2n.p1624;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-04-20
 */
public class LargestSubstringBetweenTwoEqualCharacters {

	public static void main(String[] args) {
		System.out.println(maxLengthBetweenEqualCharacters("aa"));
		System.out.println(maxLengthBetweenEqualCharacters("abca"));
		System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));
		System.out.println(maxLengthBetweenEqualCharacters("cabbac"));
		System.out.println(maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));
	}

	private static int maxLengthBetweenEqualCharacters(String s) {
		Map<Character, LinkedList<Integer>> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			LinkedList<Integer> indexes = map.get(ch) == null ? new LinkedList<>() : map.get(ch);
			indexes.add(i);
			map.put(ch, indexes);
		}

		int maxLength = Integer.MIN_VALUE;
		boolean hasAnswer = false;
		for (Character character : map.keySet()) {
			LinkedList<Integer> indexes = map.get(character);
			if (indexes.size() >= 2) {
				hasAnswer = true;
				maxLength = Math.max(maxLength, indexes.getLast() - indexes.getFirst() - 1);
			}
		}

		return hasAnswer ? maxLength : -1;
	}
}
