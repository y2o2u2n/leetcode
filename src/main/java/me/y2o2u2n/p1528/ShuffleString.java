package me.y2o2u2n.p1528;

/**
 * Created by JunSeok Youn on 2021-06-21
 */
public class ShuffleString {
	public String restoreString(String s, int[] indices) {
		int length = s.length();
		StringBuilder builder = new StringBuilder("x".repeat(length));

		for (int i = 0; i < length; i++) {
			char ch = s.charAt(i);
			int index = indices[i];
			builder.setCharAt(index, ch);
		}

		return builder.toString();
	}
}
