package me.y2o2u2n.p338;

public class CountingBits {

	public static void main(String[] args) {
		printArr(countBits(2));
		printArr(countBits(5));
	}

	// 0, 1, 2, 3, 4, 5
	// 0, 1, 10, 11, 100, 101
	private static int[] countBits(int num) {
		return v2(num);
	}

	private static int[] v1(int num) {
		int[] ret = new int[num + 1];
		ret[0] = 0;

		for (int i = 1; i <= num; i++) {
			int n = i;
			int count = 0;
			while (n > 0) {
				if (n % 2 == 1) {
					count++;
				}
				n = n / 2;
			}
			ret[i] = count;
		}

		return ret;
	}

	private static int[] v2(int num) {
		int[] ret = new int[num + 1];
		ret[0] = 0;

		for (int i = 1; i <= num; i++) {
			ret[i] = ret[i / 2] + i % 2;
		}

		return ret;
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
