package me.y2o2u2n.p69;

/**
 * Created by JunSeok Youn on 2021-02-25
 */
public class Sqrt {

	public static void main(String[] args) {
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(8));
		System.out.println(mySqrt(2147395599));
	}

	private static int mySqrt(int x) {
		int start = 0;
		int end = x;

		while (start <= end) {
			long middle = (start + end) / 2;
			if (middle * middle == x) {
				return (int) middle;
			} else if (middle * middle > x) {
				end = (int) middle - 1;
			} else if (middle * middle < x) {
				start = (int) middle + 1;
			}
		}

		return end;
	}
}
