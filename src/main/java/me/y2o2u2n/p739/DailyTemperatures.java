package me.y2o2u2n.p739;

/**
 * Created by JunSeok Youn on 2021-04-17
 */
public class DailyTemperatures {
	public static void main(String[] args) {
		// 1, 1, 4, 2, 1, 1, 0, 0
		printArr(dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}));
	}

	private static int[] dailyTemperatures(int[] T) {
		int[] ret = new int[T.length];

		for (int i = 0; i < T.length; i++) {
			int current = T[i];
			int wait = 0;

			for (int j = i + 1; j < T.length; j++) {

				if (current < T[j]) {
					wait = j - i;
					break;
				}
			}

			ret[i] = wait;
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
