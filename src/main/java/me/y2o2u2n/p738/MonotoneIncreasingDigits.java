package me.y2o2u2n.p738;

/**
 * Created by JunSeok Youn on 2021-04-20
 */
public class MonotoneIncreasingDigits {
	public static void main(String[] args) {
		System.out.println(monotoneIncreasingDigits(10)); // 9
		System.out.println(monotoneIncreasingDigits(1234)); // 1234
		System.out.println(monotoneIncreasingDigits(12334)); // 12334
		System.out.println(monotoneIncreasingDigits(332)); // 299
		System.out.println(monotoneIncreasingDigits(38193)); // 37999
	}

	private static int monotoneIncreasingDigits(int N) {
		return s2(N);
	}

	private static int s2(int N) {
		String number = String.valueOf(N);
		int prev = number.charAt(0) - '0';

		for (int i = 1; i < number.length(); i++) {
			int current = number.charAt(i) - '0';
			if (prev > current) {
				String temp = number.substring(0, i) + "0".repeat(number.length() - i);
				N = Integer.valueOf(temp) - 1;
				number = String.valueOf(N);
				prev = number.charAt(0) - '0';
				i = 0;
			} else {
				prev = current;
			}
		}

		return N;
	}

	// Time Limit Exceeded
	private static int s1(int N) {
		while (N > 0) {
			if (isGood(N)) {
				return N;
			}

			N--;
		}

		return -1;
	}

	private static boolean isGood(int n) {
		int digit = n % 10;
		n = n / 10;

		while (n > 0) {
			if (digit >= n % 10) {
				digit = n % 10;
				n = n / 10;
			} else {
				return false;
			}
		}

		return true;
	}
}
