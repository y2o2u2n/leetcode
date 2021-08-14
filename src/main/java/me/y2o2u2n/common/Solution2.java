package me.y2o2u2n.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by JunSeok Youn on 2021/08/14
 */
public class Solution2 {
	public int solution(int[][] needs, int r) {
		int n = needs[0].length;

		List<Set<Integer>> needList = new ArrayList<>();
		for (int[] need : needs) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = 0; j < need.length; j++) {
				if (need[j] == 1) {
					set.add(j);
				}
			}
			needList.add(set);
		}

		List<Set<Integer>> combinations = combinations(n, r)
			.stream()
			.map(ints -> Arrays.stream(ints).boxed().collect(Collectors.toSet()))
			.collect(Collectors.toList());

		int max = Integer.MIN_VALUE;
		for (Set<Integer> combination : combinations) {
			int count = 0;
			for (Set<Integer> need : needList) {
				if (combination.containsAll(need)) {
					count++;
				}
			}
			max = Math.max(max, count);
		}

		return max;
	}

	private void helper(List<int[]> combinations, int[] data, int start, int end, int index) {
		if (index == data.length) {
			int[] combination = data.clone();
			combinations.add(combination);
		} else if (start <= end) {
			data[index] = start;
			helper(combinations, data, start + 1, end, index + 1);
			helper(combinations, data, start + 1, end, index);
		}
	}

	public List<int[]> combinations(int n, int r) {
		List<int[]> combinations = new ArrayList<>();
		helper(combinations, new int[r], 0, n - 1, 0);
		return combinations;
	}
}
