package me.y2o2u2n.p945;

/**
 * Created by JunSeok Youn on 2021-04-20
 */
public class MinumumIncrementToMakeArrayUnique {
	public static void main(String[] args) {
		System.out.println(minIncrementForUnique(new int[] {1, 2, 2})); // 1
		System.out.println(minIncrementForUnique(new int[] {3, 2, 1, 2, 1, 7})); // 6
		System.out.println(minIncrementForUnique(new int[] {2, 2, 2, 2, 0})); // 6
		System.out.println(minIncrementForUnique(new int[] {1, 7, 7, 7, 7, 7})); // 10
	}

	private static int minIncrementForUnique(int[] A) {
		boolean[] arr = new boolean[8];
		int ret = 0;

		for (int i = 0; i < A.length; i++) {
			int num = A[i];
			if (!arr[num]) {
				arr[num] = true;
			} else {
				while (arr[num]) {
					num++;
					ret++;
				}
				arr[num] = true;
			}
		}

		return ret;
	}
}
