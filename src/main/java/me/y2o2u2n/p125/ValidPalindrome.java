package me.y2o2u2n.p125;

/**
 * Created by JunSeok Youn on 2021-04-07
 */
public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	private static boolean isPalindrome(String s) {
		char[] chars = s.toCharArray();

		StringBuilder builder = new StringBuilder();
		for (char ch : chars) {
			if ('a' <= ch && ch <= 'z') {
				builder.append(ch);
			}

			if ('A' <= ch && ch <= 'Z') {
				builder.append((char)(ch + (-'A' + 'a')));
			}

			if ('0' <= ch && ch <= '9') {
				builder.append(ch);
			}
		}

		String str = builder.toString();

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}

		}

		return true;
	}
}
