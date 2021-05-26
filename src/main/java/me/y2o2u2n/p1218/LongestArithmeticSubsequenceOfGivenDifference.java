package me.y2o2u2n.p1218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by JunSeok Youn on 2021-05-26
 */
public class LongestArithmeticSubsequenceOfGivenDifference {

	public int longestSubsequence(int[] arr, int difference) {
		return s4(arr, difference);
	}

	private int s4(int[] arr, int difference) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 1;

		for (int number : arr) {
			int target = number - difference;

			if (map.containsKey(target)) {
				map.put(number, map.get(target) + 1);
			} else {
				map.put(number, 1);
			}

			max = Math.max(max, map.get(number));
		}

		return max;
	}

	// Time Limit Exceeded
	private int s3(int[] arr, int difference) {
		List<Integer> numbers = Arrays.stream(arr)
			.boxed()
			.collect(Collectors.toList());

		if (difference == 0) {
			Map<Integer, Integer> frequency = new HashMap<>();

			for (Integer number : numbers) {
				frequency.put(number, frequency.getOrDefault(number, 0) + 1);
			}

			int maxSize = 0;
			for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
				maxSize = Math.max(maxSize, entry.getValue());
			}

			return maxSize;
		}

		Map<Integer, List<Integer>> indexesByNumber = new HashMap<>();

		for (int i = 0; i < numbers.size(); i++) {
			Integer number = numbers.get(i);
			List<Integer> indexes = indexesByNumber.getOrDefault(number, new ArrayList<>());
			indexes.add(i);
			indexesByNumber.put(number, indexes);
		}

		int max = 0;

		for (int i = 0; i < numbers.size(); i++) {
			int length = 1;

			int currentIndex = i;
			int currentNumber = numbers.get(currentIndex);

			int nextIndex = getNextIndex(indexesByNumber, currentIndex, currentNumber + difference);

			while (nextIndex != -1) {
				length++;

				currentIndex = nextIndex;
				currentNumber = numbers.get(currentIndex);

				nextIndex = getNextIndex(indexesByNumber, currentIndex, currentNumber + difference);
			}

			max = Math.max(max, length);

		}

		return max;
	}

	private int getNextIndex(Map<Integer, List<Integer>> indexesByNumber, int currentIndex, int nextNumber) {
		List<Integer> indexes = indexesByNumber.get(nextNumber);

		if (indexes == null) {
			return -1;
		}

		for (int i = 0; i < indexes.size(); i++) {
			Integer index = indexes.get(i);
			if (index > currentIndex) {
				return index;
			}
		}

		return -1;
	}

	// Wrong Answer
	private int s2(int[] arr, int difference) {
		List<Integer> numbers = Arrays.stream(arr)
			.boxed()
			.collect(Collectors.toList());

		if (difference == 0) {
			Map<Integer, Integer> frequency = new HashMap<>();

			for (Integer number : numbers) {
				frequency.put(number, frequency.getOrDefault(number, 0) + 1);
			}

			int maxSize = 0;
			for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
				maxSize = Math.max(maxSize, entry.getValue());
			}

			return maxSize;
		}

		Map<Integer, Set<Integer>> setByIndex = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			Set<Integer> set = new HashSet<>(numbers.subList(i + 1, arr.length));
			setByIndex.put(i, set);
		}

		int max = 0;

		for (int i = 0; i < numbers.size(); i++) {
			int length = 1;
			Integer current = numbers.get(i);
			Set<Integer> set = setByIndex.get(i);

			while (set.contains(current + difference)) {
				length++;
				current = current + difference;
			}

			max = Math.max(max, length);

		}

		return max;
	}

	// Wrong Answer
	private int s1(int[] arr, int difference) {
		Set<Integer> set = new HashSet<>();

		for (int n : arr) {
			set.add(n);
		}

		int max = 0;

		for (int n : arr) {
			int length = 1;

			int m = n;
			while (set.contains(m + difference)) {
				length++;
				m = m + difference;
			}

			max = Math.max(max, length);
		}

		return max;
	}
}
