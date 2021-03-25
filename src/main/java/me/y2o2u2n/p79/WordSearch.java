package me.y2o2u2n.p79;

/**
 * Created by JunSeok Youn on 2021-03-25
 */
public class WordSearch {
	public static void main(String[] args) {
		System.out.println(
			exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
		System.out.println(
			exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
		System.out.println(
			exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
		System.out.println(
			exist(new char[][] {{'a'}}, "a"));
		System.out.println(
			exist(new char[][] {{'a', 'a'}}, "aa"));
	}

	private static boolean exist(char[][] board, String word) {

		int yLength = board.length;
		int xLength = board[0].length;

		for (int y = 0; y < yLength; y++) {
			for (int x = 0; x < xLength; x++) {
				boolean visited[][] = new boolean[yLength][xLength];
				boolean ret = dfs(board, visited, y, x, word);
				if (ret) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean dfs(char[][] board, boolean[][] visited, int y, int x, String word) {
		if (word.length() == 1 && word.charAt(0) == board[y][x]) {
			return true;
		} else if (word.charAt(0) != board[y][x]) {
			return false;
		} else {
			int yLength = board.length;
			int xLength = board[0].length;

			String residue = word.substring(1);

			visited[y][x] = true;

			if (y - 1 >= 0 && !visited[y - 1][x]) {
				boolean ret = dfs(board, visited, y - 1, x, residue);
				if (ret) {
					return true;
				}
			}

			if (x - 1 >= 0 && !visited[y][x - 1]) {
				boolean ret = dfs(board, visited, y, x - 1, residue);
				if (ret) {
					return true;
				}
			}

			if (y + 1 <= yLength - 1 && !visited[y + 1][x]) {
				boolean ret = dfs(board, visited, y + 1, x, residue);
				if (ret) {
					return true;
				}
			}

			if (x + 1 <= xLength - 1 && !visited[y][x + 1]) {
				boolean ret = dfs(board, visited, y, x + 1, residue);
				if (ret) {
					return true;
				}
			}

			visited[y][x] = false;

			return false;
		}
	}
}
