package me.y2o2u2n.p1460;

/**
 * Created by JunSeok Youn on 2021-04-21
 */
public class MakeTwoArraysEqualByReversingSubArrays {

	public static void main(String[] args) {
		System.out.println(canBeEqual(new int[] {1, 2, 3, 4}, new int[] {2, 4, 1, 3}));
		System.out.println(canBeEqual(new int[] {7}, new int[] {7}));
		System.out.println(canBeEqual(new int[] {1, 12}, new int[] {12, 1}));
		System.out.println(canBeEqual(new int[] {3, 7, 9}, new int[] {3, 7, 11}));
		System.out.println(canBeEqual(new int[] {1, 1, 1, 1, 1}, new int[] {1, 1, 1, 1, 1}));
	}

	private static boolean canBeEqual(int[] target, int[] arr) {
		int n = 1001;

		int[] t = new int[n];
		for (int i : target) {
			t[i]++;
		}

		int[] a = new int[n];
		for (int i : arr) {
			a[i]++;
		}

		for (int i = 0; i < n; i++) {
			if (t[i] != a[i]) {
				return false;
			}
		}

		return true;
	}
}
