package me.y2o2u2n.p242;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-06-17
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();

		for (char ch : s.toCharArray()) {
			Integer count = sMap.getOrDefault(ch, 0);
			sMap.put(ch, count + 1);
		}

		for (char ch : t.toCharArray()) {
			Integer count = tMap.getOrDefault(ch, 0);
			tMap.put(ch, count + 1);
		}

		if (sMap.size() != tMap.size()) {
			return false;
		}

		for (char ch : sMap.keySet()) {
			Integer sCount = sMap.getOrDefault(ch, 0);
			Integer tCount = tMap.getOrDefault(ch, 0);
			if (!sCount.equals(tCount)) {
				return false;
			}
		}

		for (char ch : tMap.keySet()) {
			Integer sCount = sMap.getOrDefault(ch, 0);
			Integer tCount = tMap.getOrDefault(ch, 0);
			if (!sCount.equals(tCount)) {
				return false;
			}
		}

		return true;
	}
}
