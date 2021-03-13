package me.y2o2u2n.p49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-03-11
 */
public class GroupAnagrams {
	public static void main(String[] args) {
		// printListList(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
		// printListList(groupAnagrams(new String[] {"", ""}));
		printListList(groupAnagrams(new String[] {"ddddddddddg", "dgggggggggg"}));
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<>();
		}

		Map<String, List<String>> ans = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			if (!ans.containsKey(key)) {
				ans.put(key, new ArrayList<>());
			}
			ans.get(key).add(str);
		}

		return new ArrayList<>(ans.values());
	}

	private static void printListList(List<List<String>> listList) {
		for (List<String> list : listList) {
			for (String s : list) {
				System.out.print(s);
			}
			System.out.println();
		}
	}
}
