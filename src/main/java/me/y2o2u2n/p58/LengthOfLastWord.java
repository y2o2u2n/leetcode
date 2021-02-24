package me.y2o2u2n.p58;

/**
 * Created by JunSeok Youn on 2021-02-24
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord(" "));
		System.out.println(lengthOfLastWord("a "));
	}

	private static int lengthOfLastWord(String s) {
		String[] splited = s.split(" ");
		if (splited.length == 0) {
			return 0;
		}

		if (splited.length == 1) {
			return splited[0].length();
		}

		return splited[splited.length - 1].length();
	}
}
