package me.y2o2u2n.p1254;

/**
 * Created by JunSeok Youn on 2021-04-29
 */
public class NumberOfClosedIslands {
	public static void main(String[] args) {
		System.out.println(
			closedIsland(
				new int[][] {
					{1, 1, 1, 1, 1, 1, 1, 0},
					{1, 0, 0, 0, 0, 1, 1, 0},
					{1, 0, 1, 0, 1, 1, 1, 0},
					{1, 0, 0, 0, 0, 1, 0, 1},
					{1, 1, 1, 1, 1, 1, 1, 0}
				}
			)
		); // 2

		System.out.println(
			closedIsland(
				new int[][] {
					{0, 0, 1, 0, 0},
					{0, 1, 0, 1, 0},
					{0, 1, 1, 1, 0},
				}
			)
		); // 1

		System.out.println(
			closedIsland(
				new int[][] {
					{1, 1, 1, 1, 1, 1, 1},
					{1, 0, 0, 0, 0, 0, 1},
					{1, 0, 1, 1, 1, 0, 1},
					{1, 0, 1, 0, 1, 0, 1},
					{1, 0, 1, 1, 1, 0, 1},
					{1, 0, 0, 0, 0, 0, 1},
					{1, 1, 1, 1, 1, 1, 1}
				}
			)
		); // 2

		System.out.println(
			closedIsland(
				new int[][] {
					{0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
					{1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
					{1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
					{0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
					{0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
					{0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
					{1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
					{1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
					{1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
					{1, 1, 1, 0, 1, 1, 0, 1, 1, 0}}
			)
		); // 5

		System.out.println(
			closedIsland(
				new int[][] {
					{0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1},
					{0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1},
					{1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
					{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0},
					{1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1},
					{1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
					{1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
					{1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
					{0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
					{1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1},
					{1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0},
					{1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
					{0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
					{1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1}
				}
			)
		); // 6
	}

	private static int closedIsland(int[][] grid) {
		int yLength = grid.length;
		int xLength = grid[0].length;

		int count = 0;
		boolean[][] visited = new boolean[yLength][xLength];

		for (int y = 0; y < yLength; y++) {
			for (int x = 0; x < xLength; x++) {
				int val = grid[y][x];
				if (val == 0 && !visited[y][x]) {
					boolean ret = visit(grid, visited, y, x);
					if (ret) {
						count++;
					}
				}
			}
		}

		return count;
	}

	private static boolean visit(int[][] grid, boolean[][] visited, int y, int x) {
		int yLength = grid.length;
		int xLength = grid[0].length;

		visited[y][x] = true;

		boolean ret = true;

		if (y == 0 || y == yLength - 1 || x == 0 || x == xLength - 1) {
			ret = false;
		}

		if (y - 1 >= 0 && y - 1 < yLength && x >= 0 && x < xLength && !visited[y - 1][x] && grid[y - 1][x] == 0)
			ret = visit(grid, visited, y - 1, x) && ret;
		if (y >= 0 && y < yLength && x - 1 >= 0 && x - 1 < xLength && !visited[y][x - 1] && grid[y][x - 1] == 0)
			ret = visit(grid, visited, y, x - 1) && ret;
		if (y + 1 >= 0 && y + 1 < yLength && x >= 0 && x < xLength && !visited[y + 1][x] && grid[y + 1][x] == 0)
			ret = visit(grid, visited, y + 1, x) && ret;
		if (y >= 0 && y < yLength && x + 1 >= 0 && x + 1 < xLength && !visited[y][x + 1] && grid[y][x + 1] == 0)
			ret = visit(grid, visited, y, x + 1) && ret;

		return ret;
	}
}
