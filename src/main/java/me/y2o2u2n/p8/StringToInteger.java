package me.y2o2u2n.p8;

/**
 * Created by JunSeok Youn on 2021-02-23
 */
public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("   -42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("-91283472332"));
	}

	private static int myAtoi(String s) {
		// 1.
		String s1 = s.trim();
		if (s1.isEmpty()) {
			return 0;
		}

		// 2.
		String s2 = s1;
		boolean isNegative = false;
		if (s1.isEmpty()) {
			isNegative = false;
		}

		char firstChar = s1.charAt(0);
		if (firstChar == '-') {
			isNegative = true;
			s2 = s2.substring(1);
		} else if (firstChar == '+') {
			isNegative = false;
			s2 = s2.substring(1);
		}

		// 3.
		String s3;
		StringBuilder s3Builder = new StringBuilder();
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (c >= '0' && c <= '9') {
				s3Builder.append(c);
			} else {
				break;
			}
		}

		s3 = s3Builder.toString();

		// 4.
		int i4 = 0;
		for (int i = 0; i < s3.length(); i++) {
			if (i4 > Integer.MAX_VALUE / 10
				|| (i4 == Integer.MAX_VALUE / 10 && s3.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
				return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}

			i4 = i4 * 10 + (s3.charAt(i) - '0');
		}

		if (isNegative) {
			i4 = i4 * (-1);
		}

		return i4;
	}
}
