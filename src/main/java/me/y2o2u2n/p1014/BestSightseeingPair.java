package me.y2o2u2n.p1014;

/**
 * Created by JunSeok Youn on 2021-05-13
 */
public class BestSightseeingPair {

	public static void main(String[] args) {
		System.out.println(maxScoreSightseeingPair(new int[] {8, 1, 5, 2, 6}));
		System.out.println(maxScoreSightseeingPair(new int[] {1, 2}));
	}

	private static int maxScoreSightseeingPair(int[] values) {
		return s2(values);
	}

	private static int s2(int[] values) {
		int maxSoFar = Integer.MIN_VALUE;
		int ret = Integer.MIN_VALUE;

		for (int i = 0; i < values.length; i++) {
			ret = Math.max(ret, maxSoFar + values[i] - i);
			maxSoFar = Math.max(maxSoFar, values[i] + i);
		}

		return ret;
	}

	// Time Limit Exceeded
	private static int s1(int[] values) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				int score = values[i] + values[j] + i - j;
				max = Math.max(max, score);
			}
		}

		return max;
	}
}
