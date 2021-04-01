package me.y2o2u2n.p200;

/**
 * Created by JunSeok Youn on 2021-04-01
 */
public class NumberOfIslands {
	public static void main(String[] args) {
		System.out.println(numIslands(
			new char[][] {
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
			}
		)); // 1

		System.out.println(numIslands(
			new char[][] {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
			}
		)); // 3
	}

	private static int numIslands(char[][] grid) {
		int yLength = grid.length;
		int xLength = grid[0].length;
		boolean[][] visited = new boolean[yLength][xLength];

		int num = 0;
		for (int y = 0; y < yLength; y++) {
			for (int x = 0; x < xLength; x++) {
				if (!visited[y][x] && grid[y][x] == '1') {
					num++;
					mark(y, x, grid, visited);
				}
			}
		}

		return num;
	}

	private static void mark(int y, int x, char[][] grid, boolean[][] visited) {
		int yLength = grid.length;
		int xLength = grid[0].length;

		if ((0 <= y && y < yLength)
			&& (0 <= x && x < xLength)
			&& !visited[y][x]
			&& grid[y][x] == '1'
		) {
			visited[y][x] = true;
			mark(y - 1, x, grid, visited);
			mark(y, x - 1, grid, visited);
			mark(y, x + 1, grid, visited);
			mark(y + 1, x, grid, visited);
		}
	}
}
