package me.y2o2u2n.p974;

/**
 * Created by JunSeok Youn on 2021-05-22
 */
public class SubarraySumsDivisibleByK {

	public int subarraysDivByK(int[] A, int K) {
		return s2(A, K);
	}

	private int s2(int[] A, int K) {
		int[] count = new int[K];
		count[0] = 1;
		int prefix = 0;
		int ans = 0;

		for (int a : A) {
			prefix = (prefix + a % K + K) % K;
			ans += count[prefix]++;
		}

		return ans;
	}

	// Memory Limit Exceeded
	private int s1(int[] A, int K) {
		int ans = 0;

		int n = A.length;
		int[][] sum = new int[n][n];

		for (int i = 0; i < n; i++) {
			sum[i][i] = A[i];
			if (sum[i][i] % K == 0) {
				ans++;
			}
		}

		for (int start = 0; start < n; start++) {
			for (int end = start + 1; end < n; end++) {
				sum[start][end] = sum[start][end - 1] + A[end];
				if (sum[start][end] % K == 0) {
					ans++;
				}
			}
		}

		return ans;
	}
}
