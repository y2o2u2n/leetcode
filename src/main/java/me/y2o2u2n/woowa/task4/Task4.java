package me.y2o2u2n.woowa.task4;

import java.util.Arrays;

/**
 * Created by JunSeok Youn on 2021/07/31
 */
public class Task4 {
	int solution(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;;
		Arrays.sort(A);
		Arrays.sort(B);
		int i = 0;
		for (int k = 0; k < n; k++) {
			while (i < m - 1 && B[i] < A[k])
				i += 1;
			if (A[k] == B[i])
				return A[k];
		}
		return -1;
	}
}
