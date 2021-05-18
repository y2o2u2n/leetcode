package me.y2o2u2n.p1423;

/**
 * Created by JunSeok Youn on 2021-05-19
 */
public class MaximumPointsYouCanObtainFromCards {

	public static void main(String[] args) {
		System.out.println(maxScore(new int[] {1, 2, 3, 4, 5, 6, 1}, 3));
		System.out.println(maxScore(new int[] {2, 2, 2}, 2));
	}

	private static int maxScore(int[] cardPoints, int k) {
		int n = cardPoints.length;

		int[] frontSum = new int[k + 1];
		for (int i = 1; i <= k; i++) {
			frontSum[i] = frontSum[i - 1] + cardPoints[i - 1];
		}

		int[] backSum = new int[k + 1];
		for (int i = 1; i <= k; i++) {
			backSum[i] = backSum[i - 1] + cardPoints[n - i];
		}

		int max = 0;
		for (int i = 0; i <= k; i++) {
			max = Math.max(max, frontSum[i] + backSum[k - i]);
		}

		return max;
	}
}
