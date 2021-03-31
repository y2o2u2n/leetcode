package me.y2o2u2n.p88;

/**
 * Created by JunSeok Youn on 2021-03-31
 */
public class MergeSortedArray {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int m = 3;
		int[] nums2 = {2, 5, 6};
		int n = 3;
		merge(nums1, m, nums2, n);
		printArr(nums1);
	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] merged = new int[m + n];

		int a = 0;
		int b = 0;
		int i = 0;

		while (a < m && b < n) {
			if (nums1[a] < nums2[b]) {
				merged[i++] = nums1[a++];
			} else {
				merged[i++] = nums2[b++];
			}
		}

		while (a < m) {
			merged[i++] = nums1[a++];
		}

		while (b < n) {
			merged[i++] = nums2[b++];
		}

		// copy
		for (int x = 0; x < m + n; x++) {
			nums1[x] = merged[x];
		}
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
