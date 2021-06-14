package me.y2o2u2n.p1642;

import java.util.PriorityQueue;

/**
 * Created by JunSeok Youn on 2021/06/14
 */
public class FurthestBuildingYouCanReach {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < heights.length - 1; i++) {
			int diff = heights[i + 1] - heights[i];

			if (diff > 0) {
				pq.add(diff);
			}

			if (pq.size() > ladders) {
				bricks -= pq.poll();
			}

			if (bricks < 0) {
				return i;
			}
		}

		return heights.length - 1;
	}
}
