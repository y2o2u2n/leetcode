package me.y2o2u2n.p17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-02-26
 */
public class LetterCombinationsOfAPhoneNumber {

	private static Map<String, String> phone = Map.of(
		"2", "abc",
		"3", "def",
		"4", "ghi",
		"5", "jkl",
		"6", "mno",
		"7", "pqrs",
		"8", "tuv",
		"9", "wxyz"
	);

	private static List<String> output = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

	private static List<String> letterCombinations(String digits) {
		if (digits.length() != 0) {
			backtrack("", digits);
		}

		return output;
	}

	private static void backtrack(String combination, String nextDigits) {
		if (nextDigits.length() == 0) {
			output.add(combination);
		} else {
			String digit = nextDigits.substring(0, 1);
			String letters = phone.get(digit);
			for (int i = 0; i < letters.length(); i++) {
				String letter = letters.substring(i, i + 1);
				backtrack(combination + letter, nextDigits.substring(1));
			}
		}
	}
}
