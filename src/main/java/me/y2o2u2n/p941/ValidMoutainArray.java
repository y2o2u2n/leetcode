package me.y2o2u2n.p941;

/**
 * Created by JunSeok Youn on 2021-04-30
 */
public class ValidMoutainArray {

	public static void main(String[] args) {
		System.out.println(validMountainArray(new int[] {2, 1})); // false
		System.out.println(validMountainArray(new int[] {3, 5, 5})); // false
		System.out.println(validMountainArray(new int[] {0, 3, 2, 1})); // true
		System.out.println(validMountainArray(new int[] {0, 3, 2, 1})); // true
		System.out.println(validMountainArray(new int[] {2, 0, 2})); // false
	}

	private static boolean validMountainArray(int[] arr) {
		if (arr.length < 3) {
			return false;
		}

		int increasingCount = arr[0] < arr[1] ? 1 : 0;
		int decreasingCount = arr[0] > arr[1] ? 1 : 0;
		boolean isIncreasing = arr[0] < arr[1];

		int prev = arr[1];

		for (int i = 2; i < arr.length; i++) {
			int current = arr[i];

			if (prev == current || increasingCount > 1 || decreasingCount > 1) {
				return false;
			}

			if (prev < current) {
				if (isIncreasing) {

				} else {
					return false;
				}
			} else {
				if (isIncreasing) {
					decreasingCount++;
					isIncreasing = false;
				} else {

				}
			}

			prev = current;
		}

		return increasingCount == 1 && decreasingCount == 1;
	}
}
