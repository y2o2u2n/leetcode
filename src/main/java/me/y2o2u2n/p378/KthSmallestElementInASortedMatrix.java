package me.y2o2u2n.p378;

import java.util.PriorityQueue;

/**
 * Created by JunSeok Youn on 2021-06-22
 */
public class KthSmallestElementInASortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int yLength = matrix.length;
		int xLength = matrix[0].length;

		for (int y = 0; y < yLength; y++) {
			for (int x = 0; x < xLength; x++) {
				int value = matrix[y][x];
				pq.offer(value);
			}
		}

		int ans = 0;

		while (k-- > 0) {
			ans = pq.poll();
		}

		return ans;
	}
}
