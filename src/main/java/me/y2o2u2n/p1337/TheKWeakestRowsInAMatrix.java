package me.y2o2u2n.p1337;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by JunSeok Youn on 2021-04-19
 */
public class TheKWeakestRowsInAMatrix {

	public static void main(String[] args) {
		printArr(
			kWeakestRows(
				new int[][] {
					{1, 1, 0, 0, 0},
					{1, 1, 1, 1, 0},
					{1, 0, 0, 0, 0},
					{1, 1, 0, 0, 0},
					{1, 1, 1, 1, 1}
				},
				3)
		);

		printArr(
			kWeakestRows(
				new int[][] {
					{1, 0},
					{0, 0},
					{1, 0},
				},
				2)
		);
	}

	private static int[] kWeakestRows(int[][] mat, int k) {
		int[] ans = new int[k];
		int[][] candidates = new int[mat.length][2];

		for (int i = 0; i < mat.length; ++i) {
			candidates[i][0] = IntStream.of(mat[i]).sum();
			candidates[i][1] = i;
		}

		Arrays.sort(candidates, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		for (int i = 0; i < k; ++i)
			ans[i] = candidates[i][1];

		return ans;
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
