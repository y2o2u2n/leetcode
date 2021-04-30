package me.y2o2u2n.p1094;

/**
 * Created by JunSeok Youn on 2021-04-30
 */
public class CarPooling {

	public static void main(String[] args) {

		System.out.println(
			carPooling(
				new int[][] {
					{2, 1, 5},
					{3, 3, 7},
				},
				4
			)
		);

		System.out.println(
			carPooling(
				new int[][] {
					{2, 1, 5},
					{3, 3, 7},
				},
				5
			)
		);

		System.out.println(
			carPooling(
				new int[][] {
					{2, 1, 5},
					{3, 5, 7},
				},
				3
			)
		);

		System.out.println(
			carPooling(
				new int[][] {
					{3, 2, 7},
					{3, 7, 9},
					{8, 3, 9}
				},
				11
			)
		);
	}

	private static boolean carPooling(int[][] trips, int capacity) {
		int[] road = new int[1001];

		for (int i = 0; i < trips.length; i++) {
			int[] trip = trips[i];
			int num = trip[0];
			int start = trip[1];
			int end = trip[2];

			for (int l = start; l < end; l++) {
				road[l] += num;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < road.length; i++) {
			max = Math.max(max, road[i]);
		}

		return capacity >= max;
	}
}
