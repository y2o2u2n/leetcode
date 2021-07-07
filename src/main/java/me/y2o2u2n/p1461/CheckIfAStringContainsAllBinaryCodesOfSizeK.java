package me.y2o2u2n.p1461;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
	public boolean hasAllCodes(String s, int k) {
		return s2(s, k);
	}

	private boolean s2(String s, int k) {
		Set<String> set = new HashSet<>();

		for (int i = 0; i < s.length() - k + 1; i++) {
			String substring = s.substring(i, i + k);
			set.add(substring);
		}

		return set.size() == 1 << k;
	}

	// Time Limit Exceeded
	private boolean s1(String s, int k) {
		List<String> binaryCodes = binaryCodes(k);

		for (String binaryCode : binaryCodes) {
			if (!s.contains(binaryCode)) {
				return false;
			}
		}

		return true;
	}

	public List<String> binaryCodes(int k) {
		List<String> binaryCodes = new ArrayList<>();
		recurse("", 0, k, binaryCodes);
		return binaryCodes;
	}

	private void recurse(String string, int i, int k, List<String> strings) {
		if (i == k) {
			strings.add(string);
		} else {
			recurse(string + "0", i + 1, k, strings);
			recurse(string + "1", i + 1, k, strings);
		}
	}
}
