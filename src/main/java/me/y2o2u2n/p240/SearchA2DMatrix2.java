package me.y2o2u2n.p240;

/**
 * Created by JunSeok Youn on 2021-04-07
 */
public class SearchA2DMatrix2 {

	public static void main(String[] args) {
		System.out.println(searchMatrix(
			new int[][] {
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
			},
			5
		)); // true

		System.out.println(searchMatrix(
			new int[][] {
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
			},
			20
		)); // false
	}

	private static boolean searchMatrix(int[][] matrix, int target) {
		int yLength = matrix.length;
		int xLength = matrix[0].length;

		for (int j = 0; j < yLength; j++) {
			if (matrix[j][0] > target || matrix[j][xLength - 1] < target) {
				continue;
			}

			if (binarySearch(matrix[j], target, 0, xLength - 1)) {
				return true;
			}

		}

		return false;
	}

	private static boolean binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return false;
	}
}
