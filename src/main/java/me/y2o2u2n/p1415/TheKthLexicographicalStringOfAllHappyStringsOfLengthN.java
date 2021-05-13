package me.y2o2u2n.p1415;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-05-14
 */
public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

	public static void main(String[] args) {
		System.out.println(getHappyString(1, 3));
		System.out.println(getHappyString(1, 4));
		System.out.println(getHappyString(3, 9));
		System.out.println(getHappyString(2, 7));
		System.out.println(getHappyString(10, 100));
	}

	private static String getHappyString(int n, int k) {
		List<String> answers = new ArrayList<>();
		List<Character> chars = List.of('a', 'b', 'c');
		recursion(chars, 'x', "", n, answers);
		return answers.size() > k - 1 ? answers.get(k - 1) : "";
	}

	private static void recursion(
		List<Character> chars,
		Character prev,
		String str,
		Integer n,
		List<String> answers
	) {
		if (str.length() == n) {
			// System.out.println(str);
			answers.add(str);
		} else {
			for (Character ch : chars) {
				if (prev != ch) {
					recursion(chars, ch, str + ch, n, answers);
				}
			}
		}
	}
}
