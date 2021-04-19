package me.y2o2u2n.p791;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by JunSeok Youn on 2021-04-19
 */
public class CustomSortString {

	public static void main(String[] args) {
		System.out.println(customSortString("cba", "abcd"));
	}

	private static String customSortString(String S, String T) {
		return s2(S, T);
	}

	private static String s2(String S, String T) {
		Map<Character, Integer > countByCharacter = new HashMap<>();

		for (char t : T.toCharArray()) {
			Integer count = countByCharacter.get(t);
			countByCharacter.put(t, count == null ? 1 : count + 1);
		}

		StringBuilder answer = new StringBuilder();

		for (char s : S.toCharArray()) {
			if (T.contains(String.valueOf(s))) {
				Integer count = countByCharacter.get(s);
				answer.append(String.valueOf(s).repeat(Math.max(0, count)));
			}
		}

		for (char t : T.toCharArray()) {
			if (!S.contains(String.valueOf(t))) {
				answer.append(t);
			}
		}

		return answer.toString();
	}

	private static String s1(String S, String T) {
		int[] dic = new int['z' - 'a' + 1];

		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			dic[ch - 'a'] = S.length() - i;
		}

		List<Character> a = new ArrayList<>();
		List<Character> b = new ArrayList<>();

		for (int i = 0; i < T.length(); i++) {
			char ch = T.charAt(i);
			if (dic[ch - 'a'] > 0) {
				a.add(ch);
			} else {
				b.add(ch);
			}
		}

		a.sort(Comparator.comparingInt(o -> -dic[o - 'a']));

		return Stream.concat(a.stream(), b.stream())
			.map(Object::toString)
			.collect(Collectors.joining());
	}
}
