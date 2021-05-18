package me.y2o2u2n.p766;

/**
 * Created by JunSeok Youn on 2021-05-18
 */
public class ToeplitzMatrix {

	public static void main(String[] args) {
		System.out.println(isToeplitzMatrix(
			new int[][] {
				{1, 2, 3, 4},
				{5, 1, 2, 3},
				{9, 5, 1, 2}
			}
		));

		System.out.println(isToeplitzMatrix(
			new int[][] {
				{1, 2},
				{2, 2}
			}
		));
	}

	private static boolean isToeplitzMatrix(int[][] matrix) {
		int yLength = matrix.length;
		int xLength = matrix[0].length;

		for (int y = 0; y < yLength; y++) {
			int x = 0;
			int val = matrix[y][x];

			for (int i = 0; i < Math.min(yLength - y, xLength - x); i++) {
				int yy = y + i;
				int xx = x + i;

				if (val != matrix[yy][xx]) {
					return false;
				}
			}
		}

		for (int x = 0; x < xLength; x++) {
			int y = 0;
			int val = matrix[y][x];

			for (int i = 0; i < Math.min(yLength - y, xLength - x); i++) {
				int yy = y + i;
				int xx = x + i;

				if (val != matrix[yy][xx]) {
					return false;
				}
			}
		}

		return true;
	}
}
