package me.y2o2u2n.p394;

import java.util.Stack;

/**
 * Created by JunSeok Youn on 2021-04-12
 */
public class DecodeString {
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("abc3[cd]xyz"));
		System.out.println(decodeString("10[a2[c]]"));
	}

	private static String decodeString(String s) {
		int length = s.length();
		Stack<Integer> nums = new Stack<>();
		Stack<Character> texts = new Stack<>();
		StringBuilder n = new StringBuilder();

		for (int i = 0; i < length; i++) {
			char ch = s.charAt(i);

			if ('0' <= ch && ch <= '9') {
				n.append(ch);
			} else if ('a' <= ch && ch <= 'z') {
				texts.push(ch);
			} else if (ch == '[') {
				texts.push(ch);
				nums.push(Integer.parseInt(n.toString()));
				n = new StringBuilder();
			} else if (ch == ']') {
				Integer num = nums.pop();
				StringBuilder textStr = new StringBuilder();

				while(true) {
					Character text = texts.pop();
					if (text == '[') {
						break;
					}

					textStr.append(text);
				}

				textStr.reverse();

				for (int j = 0; j < num; j++) {
					for (int k = 0; k < textStr.length(); k++) {
						texts.add(textStr.charAt(k));
					}
				}
			}
		}


		StringBuilder ret = new StringBuilder();

		while (!texts.isEmpty()) {
			ret.append(texts.pop());
		}

		return ret.reverse().toString();

	}
}
