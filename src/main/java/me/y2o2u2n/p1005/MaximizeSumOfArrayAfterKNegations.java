package me.y2o2u2n.p1005;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by JunSeok Youn on 2021-05-05
 */
public class MaximizeSumOfArrayAfterKNegations {
	public static void main(String[] args) {
		System.out.println(largestSumAfterKNegations(new int[] {4, 2, 3}, 1)); // 5
		System.out.println(largestSumAfterKNegations(new int[] {3, -1, 0, 2}, 3)); // 6
		System.out.println(largestSumAfterKNegations(new int[] {2, -3, -1, 5, -4}, 2)); // 13
		System.out.println(largestSumAfterKNegations(new int[] {-2, 9, 9, 8, 4}, 5)); // 32
		System.out.println(largestSumAfterKNegations(new int[] {-4, -6, 9, -2, 2}, 4)); // 19
		System.out.println(largestSumAfterKNegations(new int[] {-8, 3, -5, -3, -5, -2}, 6)); // 22
	}

	private static int largestSumAfterKNegations(int[] A, int K) {
		Arrays.sort(A);

		int left = K;
		for (int i = 0; i < K && i < A.length; i++) {
			if (A[i] < 0) {
				A[i] = -A[i];
				left--;
			}
		}

		Arrays.sort(A);
		if (left % 2 == 1) {
			A[0] = -A[0];
		}

		return IntStream.of(A).sum();
	}

}
