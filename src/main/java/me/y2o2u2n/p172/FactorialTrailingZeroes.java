package me.y2o2u2n.p172;

/**
 * Created by JunSeok Youn on 2021-04-12
 */
public class FactorialTrailingZeroes {
	public static void main(String[] args) {
		System.out.println(trailingZeroes(3));
		System.out.println(trailingZeroes(5));
		System.out.println(trailingZeroes(0));
		System.out.println(trailingZeroes(13));
	}

	private static int trailingZeroes(int n) {
		return s1(n);
	}

	private static int s1(int n) {
		int[] m1 = new int[n + 1];
		int[] m2 = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			m1[i] = i % 2 == 0 ? m1[i / 2] + 1 : 0;
			m2[i] = i % 5 == 0 ? m2[i / 5] + 1 : 0;
		}

		int twoCount = 0;
		int fiveCount = 0;
		for (int i = 1; i <= n; i++) {
			twoCount += m1[i];
			fiveCount += m2[i];
		}

		return Math.min(twoCount, fiveCount);
	}
}
