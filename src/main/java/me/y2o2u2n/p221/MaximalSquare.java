package me.y2o2u2n.p221;

/**
 * Created by JunSeok Youn on 2021-04-02
 */
public class MaximalSquare {

	public static void main(String[] args) {
		System.out.println(maximalSquare(
			new char[][] {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
			}
		)); // 4

		System.out.println(maximalSquare(
			new char[][] {
				{'0', '1'}, {'1', '0'}
			}
		)); // 1

		System.out.println(maximalSquare(
			new char[][] {
				{'0'}
			}
		)); // 0
	}

	private static int maximalSquare(char[][] matrix) {
		int yLength = matrix.length;
		int xLength = matrix[0].length;
		int[][] m = new int[yLength + 1][xLength + 1];

		int ret = 0;
		for (int y = 1; y <= yLength; y++) {
			for (int x = 1; x <= xLength; x++) {
				if (matrix[y - 1][x - 1] == '1') {
					int min = Integer.MAX_VALUE;
					min = Math.min(min, m[y - 1][x]);
					min = Math.min(min, m[y - 1][x - 1]);
					min = Math.min(min, m[y][x - 1]);
					m[y][x] = min + 1;
					ret = Math.max(ret, m[y][x]);
				}
			}
		}

		return ret * ret;
	}
}
