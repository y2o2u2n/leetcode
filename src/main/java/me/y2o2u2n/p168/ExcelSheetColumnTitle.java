package me.y2o2u2n.p168;

/**
 * Created by JunSeok Youn on 2021-04-09
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(701));
		System.out.println(convertToTitle(2147483647));
	}

	private static String convertToTitle(int columnNumber) {
		String ret = "";
		int number = columnNumber - 1;
		boolean end = false;

		while (number >= 0) {

			int r = number % 26;

			ret = (char)('A' + r) + ret;

			if (end) {
				break;
			}

			number = number / 26 - 1;

			if (number == 0 && r == 0) {
				end = true;
			}
		}

		return ret;
	}
}
