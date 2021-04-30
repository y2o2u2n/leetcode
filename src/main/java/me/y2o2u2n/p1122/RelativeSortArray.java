package me.y2o2u2n.p1122;

/**
 * Created by JunSeok Youn on 2021-04-30
 */
public class RelativeSortArray {

	public static void main(String[] args) {
		printArr(relativeSortArray(
			new int[] {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
			new int[] {2, 1, 4, 3, 9, 6}
		));
	}

	private static int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] frequency = new int[1001];
		boolean[] exist = new boolean[1001];

		for (int num : arr1) {
			frequency[num]++;
		}

		for (int num : arr2) {
			exist[num] = true;
		}

		int[] ret = new int[arr1.length];
		int k = 0;

		for (int i = 0; i < arr2.length; i++) {
			int num = arr2[i];
			for (int j = 0; j < frequency[num]; j++) {
				ret[k++] = num;
			}
		}

		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] > 0 && !exist[i]) {
				for (int j = 0; j < frequency[i]; j++) {
					ret[k++] = i;
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
			System.out.print(i);
		}

		System.out.println();
	}
}
