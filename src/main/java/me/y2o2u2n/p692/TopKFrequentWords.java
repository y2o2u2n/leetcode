package me.y2o2u2n.p692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-05-05
 */
public class TopKFrequentWords {
	public static void main(String[] args) {
		printListStr(
			topKFrequent(
				new String[] {"i", "love", "leetcode", "i", "love", "coding"},
				2
			)
		);

		printListStr(
			topKFrequent(
				new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
				4
			)
		);
	}

	private static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> frequency = new HashMap<>();

		for (String word : words) {
			Integer count = frequency.get(word);
			frequency.put(word, count != null ? count + 1 : 1);
		}

		List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());

		entries.sort((o1, o2) -> {
			Integer count1 = o1.getValue();
			Integer count2 = o2.getValue();

			int compareCount = count2.compareTo(count1);
			if (compareCount != 0) {
				return compareCount;
			}

			String word1 = o1.getKey();
			String word2 = o2.getKey();

			return word1.compareTo(word2);
		});

		List<String> ret = new ArrayList<>();

		for (int i = 0; i < entries.size() && i < k; i++) {
			Map.Entry<String, Integer> entry = entries.get(i);
			ret.add(entry.getKey());
		}

		return ret;

	}

	private static void printListStr(List<String> list) {
		for (String s : list) {
			System.out.print(s);
		}

		System.out.println();
	}
}
