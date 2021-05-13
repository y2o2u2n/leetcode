package me.y2o2u2n.p977;

/**
 * Created by JunSeok Youn on 2021-05-13
 */
public class SquaresOfASortedArray {
	public static void main(String[] args) {
		printArr(sortedSquares(new int[] {-4, -1, 0, 3, 10}));
		printArr(sortedSquares(new int[] {-7, -3, 2, 3, 11}));
	}

	private static int[] sortedSquares(int[] nums) {
		int[] frequency = new int[10000 + 1];

		for (int num : nums) {
			frequency[Math.abs(num)]++;
		}

		int[] ret = new int[nums.length];
		int k = 0;
		for (int i = 0; i < frequency.length; i++) {
			int f = frequency[i];
			if (f > 0) {
				for (int j = 0; j < f; j++) {
					ret[k++] = i * i;
				}
			}
		}

		return ret;
	}

	private static void printArr(int[] arr) {
		if (arr == null) {
			return;
		}

		for (int i : arr) {
			System.out.print(i + ",");
		}

		System.out.println();
	}
}
