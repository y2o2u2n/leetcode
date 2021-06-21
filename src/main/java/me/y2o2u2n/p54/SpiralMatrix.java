package me.y2o2u2n.p54;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-06-22
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		int yLength = matrix.length;
		int xLength = matrix[0].length;
		int y = 0;
		int x = 0;

		List<Integer> ans = new ArrayList<>();
		boolean[][] visited = new boolean[yLength][xLength];
		Direction dir = Direction.RIGHT;

		while (ans.size() < yLength * xLength) {
			int current = matrix[y][x];
			ans.add(current);
			visited[y][x] = true;

			int nextY = y + dir.dy;
			int nextX = x + dir.dx;

			if (nextY < 0
				|| nextY >= yLength
				|| nextX < 0
				|| nextX >= xLength
				|| visited[nextY][nextX]) {
				dir = dir.next();
			}

			y += dir.dy;
			x += dir.dx;
		}

		return ans;
	}

	private enum Direction {
		RIGHT(0, 1),
		DOWN(1, 0),
		LEFT(0, -1),
		UP(-1, 0);

		private int dy;
		private int dx;

		Direction(int dy, int dx) {
			this.dy = dy;
			this.dx = dx;
		}

		Direction next() {
			if (this == RIGHT) {
				return DOWN;
			} else if (this == DOWN) {
				return LEFT;
			} else if (this == LEFT) {
				return UP;
			} else {
				return RIGHT;
			}
		}
	}
}
