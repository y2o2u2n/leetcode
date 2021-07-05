package me.y2o2u2n.p994;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {
	public int orangesRotting(int[][] grid) {
		int yLength = grid.length;
		int xLength = grid[0].length;

		Queue<Coordinate> queue = new LinkedList<>();

		for (int y = 0; y < yLength; y++) {
			for (int x = 0; x < xLength; x++) {
				int cell = grid[y][x];
				if (isRotten(cell)) {
					queue.add(new Coordinate(y, x));
				}
			}
		}

		int minute = 0;

		while (!queue.isEmpty()) {

			Set<Coordinate> willBeRotten = new HashSet<>();

			while (!queue.isEmpty()) {
				Coordinate coordinate = queue.poll();

				int y = coordinate.y;
				int x = coordinate.x;

				if (y - 1 >= 0 && isFresh(grid[y - 1][x]))
					willBeRotten.add(new Coordinate(y - 1, x));
				if (y + 1 < yLength && isFresh(grid[y + 1][x]))
					willBeRotten.add(new Coordinate(y + 1, x));
				if (x - 1 >= 0 && isFresh(grid[y][x - 1]))
					willBeRotten.add(new Coordinate(y, x - 1));
				if (x + 1 < xLength && isFresh(grid[y][x + 1]))
					willBeRotten.add(new Coordinate(y, x + 1));
			}

			for (Coordinate coordinate : willBeRotten) {
				grid[coordinate.y][coordinate.x] = 2;
				queue.offer(coordinate);
			}

			if (!willBeRotten.isEmpty())
				minute++;
		}

		return hasAnyFresh(grid) ? -1 : minute;
	}

	private class Coordinate {
		private int y;
		private int x;

		public Coordinate(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Coordinate that = (Coordinate)o;
			return y == that.y &&
				x == that.x;
		}

		@Override
		public int hashCode() {
			return Objects.hash(y, x);
		}
	}

	private boolean isRotten(int value) {
		return value == 2;
	}

	private boolean isFresh(int value) {
		return value == 1;
	}

	private boolean hasAnyFresh(int[][] grid) {
		int yLength = grid.length;
		int xLength = grid[0].length;

		for (int y = 0; y < yLength; y++) {
			for (int x = 0; x < xLength; x++) {
				if (isFresh(grid[y][x])) {
					return true;
				}
			}
		}

		return false;
	}
}
