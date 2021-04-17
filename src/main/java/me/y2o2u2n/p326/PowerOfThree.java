package me.y2o2u2n.p326;

/**
 * Created by JunSeok Youn on 2021-04-17
 */
public class PowerOfThree {

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(0));
		System.out.println(isPowerOfThree(9));
		System.out.println(isPowerOfThree(45));
	}

	private static boolean isPowerOfThree(int n) {
		if (n == 0) {
			return false;
		}

		while (n > 0) {
			if (n == 1) {
				return true;
			}

			if (n % 3 != 0) {
				return false;
			}

			n = n / 3;
		}

		return false;
	}
}
