package me.y2o2u2n.p1002;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-05-13
 */
public class FindCommonCharacters {

	public static void main(String[] args) {
		printListStr(commonChars(new String[] {"bella", "label", "roller"}));
		printListStr(commonChars(new String[] {"cool", "lock", "cook"}));
	}

	private static List<String> commonChars(String[] A) {
		int[][] frequency = new int[A.length]['z' - 'a' + 1];

		for (int i = 0; i < A.length; i++) {
			String str = A[i];
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				frequency[i][ch - 'a']++;
			}
		}

		List<String> ret = new ArrayList<>();
		for (int j = 0; j < 'z' - 'a' + 1; j++) {
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < A.length; i++) {
				min = Math.min(min, frequency[i][j]);
			}

			if (min >= 1) {
				for (int k = 0; k < min; k++) {
					ret.add(String.valueOf((char) (j + 'a')));
				}
			}
		}

		return ret;
	}

	private static void printListStr(List<String> list) {
		for (String s : list) {
			System.out.print(s + ", ");
		}

		System.out.println();
	}
}
