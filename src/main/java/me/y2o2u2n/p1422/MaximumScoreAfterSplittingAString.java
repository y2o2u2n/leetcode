package me.y2o2u2n.p1422;

/**
 * Created by JunSeok Youn on 2021-04-29
 */
public class MaximumScoreAfterSplittingAString {

	public static void main(String[] args) {
		System.out.println(maxScore("011101")); // 5
		System.out.println(maxScore("00111")); // 5
		System.out.println(maxScore("1111")); // 3

	}

	private static int maxScore(String s) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < s.length() - 1; i++) {
			String left = s.substring(0, i + 1);
			String right = s.substring(i + 1);

			int current = count(left, '0') + count(right, '1');

			max = Math.max(max, current);
		}

		return max;
	}

	private static int count(String str, char ch) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}

		return count;
	}
}
