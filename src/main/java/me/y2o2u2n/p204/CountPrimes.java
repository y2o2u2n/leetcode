package me.y2o2u2n.p204;

import java.util.Arrays;

/**
 * Created by JunSeok Youn on 2021-04-13
 */
public class CountPrimes {

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
		System.out.println(countPrimes(2));
	}

	private static int countPrimes(int n) {
		if (n == 0 || n == 1) {
			return 0;
		}

		boolean[] m = new boolean[n];
		Arrays.fill(m, true);

		for (int i = 2; i < n; i++) {
			for (int j = 2; i * j < n; j++) {
				m[i * j] = false;
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (m[i]) {
				count++;
			}

		}

		return count;
	}
}
