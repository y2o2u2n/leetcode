package me.y2o2u2n.p784;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021/07/01
 */
public class LetterCasePermutation {
	public List<String> letterCasePermutation(String s) {
		List<String> ans = new ArrayList<>();
		perm(s, "", 0, ans);
		return ans;
	}

	private void perm(String string, String appended, int index, List<String> ans) {
		if (string.length() == appended.length()) {
			// System.out.println(appended);
			ans.add(appended);
			return;
		}

		char c = string.charAt(index);
		if (c >= '0' && c <= '9') {
			perm(string, appended + c, index + 1, ans);
		} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			char lower = Character.toLowerCase(c);
			perm(string, appended + lower, index + 1, ans);
			char upper = Character.toUpperCase(c);
			perm(string, appended + upper, index + 1, ans);
		}
	}
}
