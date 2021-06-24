package me.y2o2u2n.p1184;

/**
 * Created by JunSeok Youn on 2021-06-24
 */
public class DistanceBetweenBusStops {
	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int n = distance.length;
		int ans = Integer.MAX_VALUE;
		int current;
		int d;

		// clockwise
		current = start;
		d = 0;
		while (current != destination) {
			d += distance[current];

			if (current == n - 1) {
				current = 0;
			} else {
				current++;
			}
		}

		ans = Math.min(ans, d);

		// anti clockwise
		current = start;
		d = 0;
		while (current != destination) {
			d += distance[current == 0 ? n - 1 : current - 1];

			if (current == 0) {
				current = n - 1;
			} else {
				current--;
			}
		}

		ans = Math.min(ans, d);

		return ans;
	}
}
