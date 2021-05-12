package me.y2o2u2n.p128;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-05-13
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// System.out.println(longestConsecutive(new int[] {})); // 0
		// System.out.println(longestConsecutive(new int[] {0, -1})); // 2
		// System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2})); // 4
		// System.out.println(longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
		System.out.println(
			longestConsecutive(new int[] {-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7})); // 4
	}

	private static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		Map<Integer, Deque<Integer>> firstMap = new HashMap<>();
		Map<Integer, Deque<Integer>> lastMap = new HashMap<>();

		for (int num : nums) {
			if (set.contains(num)) {
				continue;
			}
			set.add(num);
			int prev = num - 1;
			int next = num + 1;

			if (lastMap.containsKey(prev)) {
				Deque<Integer> dequeA = lastMap.get(prev);

				firstMap.remove(dequeA.getFirst());
				lastMap.remove(dequeA.getLast());

				dequeA.addLast(num);

				firstMap.put(dequeA.getFirst(), dequeA);
				lastMap.put(dequeA.getLast(), dequeA);

				//
				while (firstMap.containsKey(dequeA.getLast() + 1)) {
					Deque<Integer> dequeB = firstMap.get(dequeA.getLast() + 1);

					firstMap.remove(dequeA.getFirst());
					lastMap.remove(dequeA.getLast());
					firstMap.remove(dequeB.getFirst());
					lastMap.remove(dequeB.getLast());

					dequeA.addAll(dequeB);

					firstMap.put(dequeA.getFirst(), dequeA);
					lastMap.put(dequeA.getLast(), dequeA);
				}

				while (lastMap.containsKey(dequeA.getFirst() - 1)) {
					Deque<Integer> dequeB = lastMap.get(dequeA.getFirst() - 1);

					firstMap.remove(dequeA.getFirst());
					lastMap.remove(dequeA.getLast());
					firstMap.remove(dequeB.getFirst());
					lastMap.remove(dequeB.getLast());

					dequeB.addAll(dequeA);

					firstMap.put(dequeB.getFirst(), dequeB);
					lastMap.put(dequeB.getLast(), dequeB);

					dequeA = dequeB;
				}
				//
			} else {
				if (firstMap.containsKey(next)) {
					Deque<Integer> dequeA = firstMap.get(next);

					firstMap.remove(dequeA.getFirst());
					lastMap.remove(dequeA.getLast());

					dequeA.addFirst(num);

					firstMap.put(dequeA.getFirst(), dequeA);
					lastMap.put(dequeA.getLast(), dequeA);

					//
					while (firstMap.containsKey(dequeA.getLast() + 1)) {
						Deque<Integer> dequeB = firstMap.get(dequeA.getLast() + 1);

						firstMap.remove(dequeA.getFirst());
						lastMap.remove(dequeA.getLast());
						firstMap.remove(dequeB.getFirst());
						lastMap.remove(dequeB.getLast());

						dequeA.addAll(dequeB);

						firstMap.put(dequeA.getFirst(), dequeA);
						lastMap.put(dequeA.getLast(), dequeA);
					}

					while (lastMap.containsKey(dequeA.getFirst() - 1)) {
						Deque<Integer> dequeB = lastMap.get(dequeA.getFirst() - 1);

						firstMap.remove(dequeA.getFirst());
						lastMap.remove(dequeA.getLast());
						firstMap.remove(dequeB.getFirst());
						lastMap.remove(dequeB.getLast());

						dequeB.addAll(dequeA);

						firstMap.put(dequeB.getFirst(), dequeB);
						lastMap.put(dequeB.getLast(), dequeB);

						dequeA = dequeB;
					}

				} else {
					Deque<Integer> deque = new LinkedList<>();
					deque.add(num);
					firstMap.put(num, deque);
					lastMap.put(num, deque);
				}
			}
		}

		int max = 0;
		for (Map.Entry<Integer, Deque<Integer>> entry : firstMap.entrySet()) {
			max = Math.max(max, entry.getValue().size());
		}

		return max;
	}
}
