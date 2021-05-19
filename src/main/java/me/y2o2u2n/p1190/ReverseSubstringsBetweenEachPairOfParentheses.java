package me.y2o2u2n.p1190;

/**
 * Created by JunSeok Youn on 2021-05-19
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

	public String reverseParentheses(String s) {
		// (ed(et(oc))el)
		// (ed(etco)el)
		// (edocteel)
		// (leetcode)

		while (true) {
			int leftIndex = s.lastIndexOf('(');
			int rightIndex = -1;

			for (int i = leftIndex + 1; i < s.length(); i++) {
				if (s.charAt(i) == ')') {
					rightIndex = i;
					break;
				}
			}

			if (leftIndex == -1 || rightIndex == -1) {
				break;
			}

			String front = s.substring(0, leftIndex);
			String back = s.substring(rightIndex + 1);
			String middle = s.substring(leftIndex + 1, rightIndex);
			String reverse = new StringBuilder(middle).reverse().toString();
			s = front + reverse + back;

			System.out.println(String.format("%s %s %s %s %s", s, front, back, middle, reverse));
		}

		return s;
	}
}
