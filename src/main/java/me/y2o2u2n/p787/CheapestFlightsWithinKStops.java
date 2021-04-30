package me.y2o2u2n.p787;

import java.util.Arrays;

/**
 * Created by JunSeok Youn on 2021-04-30
 */
public class CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		System.out.println(
			findCheapestPrice(
				3,
				new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
				0,
				2,
				1
			)
		);

		System.out.println(
			findCheapestPrice(
				3,
				new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
				0,
				2,
				0
			)
		);
	}

	private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		return s2(n, flights, src, dst, K);
	}

	private static int s2(int n, int[][] flights, int src, int dst, int K) {
		int[] prices = new int[n];
		Arrays.fill(prices, Integer.MAX_VALUE);
		prices[src] = 0;

		for (int i = 0; i <= K; i++) {
			int[] temp = Arrays.copyOf(prices, n);

			for (int[] flight : flights) {
				int from = flight[0];
				int to = flight[1];
				int price = flight[2];

				if (prices[from] == Integer.MAX_VALUE)
					continue;

				temp[to] = Math.min(temp[to], prices[from] + price);
			}

			prices = temp;
		}

		return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;
	}

	// Time Limit Exceeded
	private static int s1(int[][] flights, int src, int dst, int K) {
		int find = find(flights, src, dst, K, 0);
		return find != Integer.MAX_VALUE ? find : -1;
	}

	private static int find(int[][] flights, int src, int dst, int k, int cost) {
		if (src == dst) {
			return cost;
		}

		if (k == -1) {
			return Integer.MAX_VALUE;
		}

		int min = Integer.MAX_VALUE;

		for (int[] flight : flights) {
			int from = flight[0];
			int to = flight[1];
			int price = flight[2];

			if (src != from) {
				continue;
			}

			int find = find(flights, to, dst, k - 1, cost + price);
			min = Math.min(min, find);
		}

		return min;
	}
}
