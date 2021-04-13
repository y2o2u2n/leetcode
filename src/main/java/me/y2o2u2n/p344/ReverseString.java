package me.y2o2u2n.p344;

/**
 * Created by JunSeok Youn on 2021-04-13
 */
public class ReverseString {

	public static void main(String[] args) {
		char[] s1 = new char[] {'h', 'e', 'l', 'l', 'o'};
		reverseString(s1);
		System.out.println(s1);
	}

	private static void reverseString(char[] s) {
		for (int i = 0; i < s.length / 2; i++) {
			char temp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = temp;
		}
	}
}
