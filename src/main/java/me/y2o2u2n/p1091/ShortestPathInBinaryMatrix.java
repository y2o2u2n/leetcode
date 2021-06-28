package me.y2o2u2n.p1091;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JunSeok Youn on 2021-06-28
 */
public class ShortestPathInBinaryMatrix {

	public int shortestPathBinaryMatrix(int[][] grid) {
		int yLength = grid.length;
		int xLength = grid[0].length;

		if (grid[0][0] == 1 || grid[yLength - 1][xLength - 1] == 1) {
			return -1;
		}

		boolean[][] visited = new boolean[yLength][xLength];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});

		int ans = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cell = queue.poll();
				int cy = cell[0];
				int cx = cell[1];

				if (cy == yLength - 1 && cx == xLength - 1) {
					return ans + 1;
				}

				for (int dy = -1; dy <= 1; dy++) {
					for (int dx = -1; dx <= 1; dx++) {
						if (dy == 0 && dx == 0) {
							continue;
						}

						int ny = cy + dy;
						int nx = cx + dx;

						if (ny >= 0
							&& ny < yLength
							&& nx >= 0
							&& nx < xLength
							&& grid[ny][nx] == 0
							&& !visited[ny][nx]) {

							queue.offer(new int[] {ny, nx});
							visited[ny][nx] = true;
						}
					}
				}
			}

			ans++;
		}

		return -1;
	}
}
