package me.y2o2u2n.p387;

/**
 * Created by JunSeok Youn on 2021-04-15
 */
public class FirstUniqueCharacterInAString {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
		System.out.println(firstUniqChar("aabb"));
	}

	private static int firstUniqChar(String s) {
		int[] count = new int['z' - 'a' + 1];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			count[ch - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (count[ch - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}
}
