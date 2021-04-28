package me.y2o2u2n.p693;

/**
 * Created by JunSeok Youn on 2021-04-28
 */
public class BinaryNumberWithAlternatingBits {

	public static void main(String[] args) {
		System.out.println(hasAlternatingBits(5));
		System.out.println(hasAlternatingBits(7));
		System.out.println(hasAlternatingBits(11));
		System.out.println(hasAlternatingBits(10));
	}

	private static boolean hasAlternatingBits(int n) {
		int prev = -1;
		while (n > 0) {
			int bit = n % 2;
			if (bit == prev) {
				return false;
			}

			prev = bit;
			n /= 2;
		}

		return true;
	}
}
