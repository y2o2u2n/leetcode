package me.y2o2u2n.p67;

/**
 * Created by JunSeok Youn on 2021-02-25
 */
public class AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1010", "1011"));
		System.out.println(addBinary("0", "0"));
		System.out.println(addBinary("1111", "1111"));
	}

	private static String addBinary(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		boolean plus = false;
		String ret = "";

		while (i >= 0 && j >= 0) {
			int aCh = (a.charAt(i) - '0');
			int bCh = (b.charAt(j) - '0');

			int sum = aCh + bCh + (plus ? 1 : 0);
			if (sum >= 2) {
				ret = sum % 2 + ret;
				plus = true;
			} else {
				ret = sum + ret;
				plus = false;
			}

			i--;
			j--;
		}

		while (i >= 0) {
			int aCh = (a.charAt(i) - '0');
			int sum = aCh + (plus ? 1 : 0);

			if (sum >= 2) {
				ret = sum % 2 + ret;
				plus = true;
			} else {
				ret = sum + ret;
				plus = false;
			}

			i--;
		}

		while (j >= 0) {
			int bCh = (b.charAt(j) - '0');
			int sum = bCh + (plus ? 1 : 0);

			if (sum >= 2) {
				ret = sum % 2 + ret;
				plus = true;
			} else {
				ret = sum + ret;
				plus = false;
			}

			j--;
		}

		if (plus) {
			ret = 1 + ret;
		}

		return ret;
	}
}
