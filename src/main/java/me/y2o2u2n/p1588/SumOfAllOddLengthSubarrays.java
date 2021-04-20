package me.y2o2u2n.p1588;

/**
 * Created by JunSeok Youn on 2021-04-20
 */
public class SumOfAllOddLengthSubarrays {

	public static void main(String[] args) {
		System.out.println(sumOddLengthSubarrays(new int[] {1, 4, 2, 5, 3}));
	}

	private static int sumOddLengthSubarrays(int[] arr) {
		int ret = 0;

		for (int length = 1; length <= arr.length; length += 2) {
			for (int i = 0; i < arr.length; i++) {
				int start = i;
				int end = i + length - 1;
				int sum = 0;

				if (!(start >= 0 && end < arr.length)) {
					break;
				}

				for (int j = start; j <= end; j++) {
						sum += arr[j];
				}

				// System.out.println(sum);
				ret += sum;
			}
		}

		return ret;
	}
}
