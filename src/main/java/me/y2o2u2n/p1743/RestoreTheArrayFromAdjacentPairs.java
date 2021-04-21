package me.y2o2u2n.p1743;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-21
 */
public class RestoreTheArrayFromAdjacentPairs {
	public static void main(String[] args) {
		printArr(restoreArray(
			new int[][] {
				{2, 1},
				{3, 4},
				{3, 2}
			}
		));

		printArr(restoreArray(
			new int[][] {
				{100000, -100000}
			}
		));

		printArr(restoreArray(
			new int[][] {
				{4, -2},
				{1, 4},
				{-3, 1}
			}
		));
	}

	private static int[] restoreArray(int[][] adjacentPairs) {
		Map<Integer, List<Integer>> h = new HashMap<>();

		for (int[] adjacentPair : adjacentPairs) {
			int first = adjacentPair[0];
			int second = adjacentPair[1];

			if (h.containsKey(first))
				h.get(first).add(second);
			else {
				List<Integer> l = new ArrayList<>();
				l.add(second);
				h.put(first, l);
			}

			if (h.containsKey(second))
				h.get(second).add(first);
			else {
				List<Integer> l = new ArrayList<>();
				l.add(first);
				h.put(second, l);
			}
		}

		int start = 0;

		for (int key : h.keySet()) {
			if (h.get(key).size() == 1) {
				start = key;
				break;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		queue.add(start);
		visited.add(start);

		int j = 0;
		int[] ret = new int[adjacentPairs.length + 1];

		while (!queue.isEmpty()) {
			int current = queue.poll();
			List<Integer> candidates = h.get(current);
			ret[j] = current;
			j++;

			for (Integer next : candidates) {
				if (!visited.contains(next)) {
					visited.add(next);
					queue.offer(next);
				}
			}
		}

		return ret;
	}

	private static void printArr(int[] arr) {
		if (arr == null) {
			return;
		}

		for (int i : arr) {
			System.out.print(i);
		}

		System.out.println();
	}

}
