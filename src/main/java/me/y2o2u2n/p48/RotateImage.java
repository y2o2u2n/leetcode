package me.y2o2u2n.p48;

/**
 * Created by JunSeok Youn on 2021-03-11
 */
public class RotateImage {
	public static void main(String[] args) {
		int[][] m1 = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
		};
		print2ndArr(m1);
		rotate(m1);
		print2ndArr(m1);

		int[][] m2 = new int[][] {
			{1, 2},
			{3, 4},
		};
		print2ndArr(m2);
		rotate(m2);
		print2ndArr(m2);
	}

	private static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = temp;
			}

		}
	}

	private static void print2ndArr(int[][] matrix) {
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val);
			}
			System.out.println();
		}
	}
}
