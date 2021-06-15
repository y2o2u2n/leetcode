package me.y2o2u2n.p542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
public class ZeroOneMatrix {
	public int[][] updateMatrix(int[][] mat) {
		return s2(mat);
	}

	private int[][] s2(int[][] mat) {
		int yLength = mat.length;
		int xLength = mat[0].length;

		Queue<int[]> queue = new LinkedList<>();
		for (int y = 0; y < yLength; y++) {
			for (int x = 0; x < xLength; x++) {
				if (mat[y][x] == 0) {
					queue.offer(new int[] {y, x});
				} else {
					mat[y][x] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			for (int[] direction : directions) {
				int y = cell[0] + direction[0];
				int x = cell[1] + direction[1];
				if (y < 0 || y >= yLength || x < 0 || x >= xLength || mat[y][x] <= mat[cell[0]][cell[1]] + 1)
					continue;
				queue.add(new int[] {y, x});
				mat[y][x] = mat[cell[0]][cell[1]] + 1;
			}
		}

		return mat;
	}

	// Wrong Answer
	private int[][] s1(int[][] mat) {
		int yLength = mat.length;
		int xLength = mat[0].length;
		int[][] ans = new int[yLength][xLength];

		for (int y = 0; y < yLength; y++) {
			for (int x = 0; x < xLength; x++) {
				if (mat[y][x] == 0) {
					ans[y][x] = 0;
				} else if (mat[y][x] == 1) {
					boolean[][] visited = new boolean[yLength][xLength];
					visited[y][x] = true;
					ans[y][x] = visit(mat, visited, y, x);
					visited[y][x] = false;
				}
			}
		}

		return ans;
	}

	private int visit(int[][] mat, boolean[][] visited, int y, int x) {
		if (mat[y][x] == 0) {
			return 0;
		}

		int yLength = mat.length;
		int xLength = mat[0].length;
		int min = 1;

		if (y - 1 >= 0 && !visited[y - 1][x]) {
			visited[y - 1][x] = true;
			min = Math.min(min, visit(mat, visited, y - 1, x));
			visited[y - 1][x] = false;
		}

		if (y + 1 < yLength && !visited[y + 1][x]) {
			visited[y + 1][x] = true;
			min = Math.min(min, visit(mat, visited, y + 1, x));
			visited[y + 1][x] = false;
		}

		if (x - 1 >= 0 && !visited[y][x - 1]) {
			visited[y][x - 1] = true;
			min = Math.min(min, visit(mat, visited, y, x - 1));
			visited[y][x - 1] = false;
		}

		if (x + 1 < xLength && !visited[y][x + 1]) {
			visited[y][x + 1] = true;
			min = Math.min(min, visit(mat, visited, y, x + 1));
			visited[y][x + 1] = false;
		}

		return min + 1;
	}
}
