package me.y2o2u2n.p22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-03-03
 */
public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	private static List<String> generateParenthesis(int n) {
		ArrayList<String> ret = new ArrayList<>();
		combination(0, 0, n, "", ret);
		return ret;
	}

	private static void combination(int left, int right, int n, String str, List<String> ret) {
		if (left == n && right == n) {
			System.out.println(str);
			ret.add(str);
		} else {
			if (left < n)
				combination(left + 1, right, n, str + "(", ret);
			if (right < n && left > right)
				combination(left, right + 1, n, str + ")", ret);
		}
	}
}
