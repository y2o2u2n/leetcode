package me.y2o2u2n.p1562;

/**
 * Created by JunSeok Youn on 2021-04-28
 */
public class FindLatestGroupOfSizeM {
	public static void main(String[] args) {
		System.out.println(findLatestStep(new int[] {3, 5, 1, 2, 4}, 1));
		System.out.println(findLatestStep(new int[] {3, 1, 5, 4, 2}, 2));
		System.out.println(findLatestStep(new int[] {1}, 1));
		System.out.println(findLatestStep(new int[] {2, 1}, 2));
	}

	private static int findLatestStep(int[] arr, int m) {
		return s2(arr, m);
	}

	// Time Limit Exceeded
	private static int s2(int[] arr, int m) {
		String bits = "1".repeat(arr.length);
		if (arr.length == m) {
			return arr.length;
		}

		for (int i = arr.length - 1; i > 0; i--) {
			int index = arr[i];
			StringBuilder newBits = new StringBuilder(bits);
			newBits.setCharAt(index - 1, '0');
			bits = newBits.toString();
			String[] split = bits.split("0");
			for (String str : split) {
				if (str.length() == m) {
					return i;
				}
			}
		}

		return -1;
	}

	// Time Limit Exceeded
	private static int s1(int[] arr, int m) {
		String bits = "0".repeat(arr.length);
		int latestIndex = -1;

		for (int i = 0; i < arr.length; i++) {
			int index = arr[i];
			StringBuilder newBits = new StringBuilder(bits);
			newBits.setCharAt(index - 1, '1');
			bits = newBits.toString();
			String[] split = bits.split("0");
			for (String str : split) {
				if (str.length() == m) {
					latestIndex = i + 1;
					break;
				}
			}
		}

		return latestIndex;
	}
}
