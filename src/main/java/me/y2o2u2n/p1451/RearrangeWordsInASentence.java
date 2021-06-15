package me.y2o2u2n.p1451;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
public class RearrangeWordsInASentence {
	public String arrangeWords(String text) {
		String lowerCase = text.toLowerCase();
		String[] split = lowerCase.split(" ");
		Arrays.sort(split, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		String join = String.join(" ", split);
		StringBuilder stringBuilder = new StringBuilder(join);
		stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));

		return stringBuilder.toString();
	}
}
